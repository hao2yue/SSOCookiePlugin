
package com.doctorai.kisso;

import com.doctorai.kisso.security.token.SSOToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * SSO 插件接口
 * </p>
 *
 * @author zhaoshihao
 * @since 2017-0805
 */
public abstract class SSOPlugin {

    /**
     * <p>
     * 登录时调用该方法
     * </p>
     *
     * @param request
     * @param response
     * @return
     */
    public abstract boolean login(HttpServletRequest request, HttpServletResponse response);


    /**
     * <p>
     * 登录后获取 Token 时调用该方法
     * </p>
     * <p>
     * 用来验证 Token 合法性（例如 time 超时验证）
     * </p>
     *
     * @param ssoToken 登录票据
     * @return
     */
    public boolean validateToken(SSOToken ssoToken) {
        return true;
    }


    /**
     * <p>
     * 退出时调用该方法
     * </p>
     *
     * @param request
     * @param response
     * @return
     */
    public abstract boolean logout(HttpServletRequest request, HttpServletResponse response);
}
