
package com.zsh.kisso.web.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * SSO Handler 拦截器接口
 * </p>
 *
 * @author zhaoshihao
 * @since 2015-12-19
 */
public interface SSOHandlerInterceptor {

    /**
     * token 为空未登录, 拦截到 AJAX 方法时
     *
     * @param request
     * @param response
     * @return
     */
    boolean preTokenIsNullAjax(HttpServletRequest request, HttpServletResponse response);

    /**
     * token 为空未登录, 自定义处理逻辑
     * <p>
     * 返回 true 继续执行（清理登录状态，重定向至登录界面），false 停止执行
     * </p>
     *
     * @param request
     * @param response
     * @return true 继续执行，false 停止执行
     */
    boolean preTokenIsNull(HttpServletRequest request, HttpServletResponse response);

}
