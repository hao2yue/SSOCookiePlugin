
package com.zsh.kisso.service;

import com.zsh.kisso.SSOCache;
import com.zsh.kisso.SSOConfig;
import com.zsh.kisso.SSOPlugin;
import com.zsh.kisso.common.CookieHelper;
import com.zsh.kisso.common.util.HttpUtil;
import com.zsh.kisso.common.util.RandomUtil;
import com.zsh.kisso.enums.TokenFlag;
import com.zsh.kisso.security.token.SSOToken;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * SSO 单点登录服务抽象实现类
 * </p>
 *
 * @author zhaoshihao
 * @since 2015-12-03
 */
public abstract class AbstractKissoService extends KissoServiceSupport implements IKissoService {

    /**
     * 获取当前请求 SSOToken
     * <p>
     * 从 Cookie 解密 SSOToken 使用场景，拦截器，非拦截器建议使用 attrSSOToken 减少二次解密
     * </p>
     *
     * @param request
     * @return SSOToken {@link SSOToken}
     */
    @Override
    public SSOToken getSSOToken(HttpServletRequest request) {
        SSOToken tk = checkIpBrowser(request, cacheSSOToken(request, config.getCache()));
        /**
         * 执行插件逻辑
         */
        List<SSOPlugin> pluginList = config.getPluginList();
        if (pluginList != null) {
            for (SSOPlugin plugin : pluginList) {
                boolean valid = plugin.validateToken(tk);
                if (!valid) {
                    return null;
                }
            }
        }
        return tk;
    }

    /**
     * <p>
     * 踢出 指定用户 ID 的登录用户，退出当前系统。
     * </p>
     *
     * @param userId 用户ID
     * @return
     */
    @Override
    public boolean kickLogin(Object userId) {
        SSOCache cache = config.getCache();
        if (cache != null) {
            return cache.delete(SSOConfig.toCacheKey(userId));
        } else {
            logger.info(" kickLogin! please implements SSOCache class.");
        }
        return false;
    }

    /**
     * 当前访问域下设置登录Cookie
     * <p>
     * <p>
     * request.setAttribute(SSOConfig.SSO_COOKIE_MAXAGE, -1);
     * 可以设置 Cookie 超时时间 ，默认读取配置文件数据 。
     * -1 浏览器关闭时自动删除 0 立即删除 120 表示Cookie有效期2分钟(以秒为单位)
     * </p>
     *
     * @param request
     * @param response
     */
    @Override
    public void setCookie(HttpServletRequest request, HttpServletResponse response, SSOToken ssoToken) {
        /**
         * 设置加密 Cookie
         */
        Cookie ck = this.generateCookie(request, ssoToken);

        /**
         * 判断 SSOToken 是否缓存处理失效
         * <p>
         * cache 缓存宕机，flag 设置为失效
         * </p>
         */
        SSOCache cache = config.getCache();
        if (cache != null) {
            boolean rlt = cache.set(ssoToken.toCacheKey(), ssoToken, config.getCacheExpires());
            if (!rlt) {
                ssoToken.setFlag(TokenFlag.CACHE_SHUT);
            }
        }

        /**
         * 执行插件逻辑
         */
        List<SSOPlugin> pluginList = config.getPluginList();
        if (pluginList != null) {
            for (SSOPlugin plugin : pluginList) {
                boolean login = plugin.login(request, response);
                if (!login) {
                    plugin.login(request, response);
                }
            }
        }

        /**
         * Cookie设置HttpOnly
         */
        if (config.getCookieHttponly()) {
            CookieHelper.addHttpOnlyCookie(response, ck);
        } else {
            response.addCookie(ck);
        }
    }

    /**
     * 当前访问域下设置登录Cookie 设置防止伪造SESSIONID攻击
     *
     * @param request
     * @param response
     */
    public void authCookie(HttpServletRequest request, HttpServletResponse response, SSOToken SSOToken) {
        CookieHelper.authJSESSIONID(request, RandomUtil.getCharacterAndNumber(8));
        this.setCookie(request, response, SSOToken);
    }

    /**
     * 清除登录状态
     *
     * @param request
     * @param response
     * @return boolean true 成功, false 失败
     */
    @Override
    public boolean clearLogin(HttpServletRequest request, HttpServletResponse response) {
        return logout(request, response, config.getCache());
    }

    /**
     * <p>
     * 重新登录 退出当前登录状态、重定向至登录页.
     * </p>
     *
     * @param request
     * @param response
     */
    @Override
    public void clearRedirectLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {

		/* 清理当前登录状态 */
        clearLogin(request, response);

        /* redirect login page */
        String loginUrl = config.getLoginUrl();
        if ("".equals(loginUrl)) {
            response.getWriter().write("{\"state\":\"-2\", \"data\":\"Please login\"}");
        } else {
            String retUrl = HttpUtil.getQueryString(request, config.getEncoding());
            logger.debug("loginAgain redirect pageUrl.." + retUrl);
            response.sendRedirect(HttpUtil.encodeRetURL(loginUrl, config.getParamReturl(), retUrl));
        }
    }

    /**
     * SSO 退出登录
     */
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /* delete cookie */
        logout(request, response, config.getCache());

		/* redirect logout page */
        String logoutUrl = config.getLogoutUrl();
        if ("".equals(logoutUrl)) {
            response.getWriter().write("sso.properties Must include: sso.logout.url");
        } else {
            response.sendRedirect(logoutUrl);
        }
    }

}
