
package com.doctorai.kisso.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doctorai.kisso.security.token.SSOToken;

/**
 * <p>
 * SSO 单点登录服务
 * </p>
 *
 * @author zhaoshihao
 * @since 2015-12-03
 */
public interface IKissoService {

    /**
     * <p>
     * 获取登录 SSOToken
     * </p>
     */
    SSOToken getSSOToken(HttpServletRequest request);

    /**
     * <p>
     * 踢出 指定用户 ID 的登录用户，退出当前系统。
     * </p>
     *
     * @param userId 用户ID
     * @return
     */
    boolean kickLogin(Object userId);

    /**
     * <p>
     * 设置登录 Cookie
     * </p>
     */
    void setCookie(HttpServletRequest request, HttpServletResponse response, SSOToken SSOToken);

    /**
     * <p>
     * 清理登录状态
     * </p>
     */
    boolean clearLogin(HttpServletRequest request, HttpServletResponse response);

    /**
     * <p>
     * 退出并跳至登录页
     * </p>
     */
    void clearRedirectLogin(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
