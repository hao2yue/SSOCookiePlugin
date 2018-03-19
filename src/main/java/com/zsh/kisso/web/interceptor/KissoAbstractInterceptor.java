
package com.zsh.kisso.web.interceptor;

import com.zsh.kisso.web.handler.KissoDefaultHandler;
import com.zsh.kisso.web.handler.SSOHandlerInterceptor;

/**
 * 登录权限验证
 * <p>
 * kisso 拦截器接口
 * </p>
 *
 * @author zhaoshihao
 * @since 2015-12-23
 */
public abstract class KissoAbstractInterceptor {

    /* SSO 拦截控制器 */
    private SSOHandlerInterceptor handlerInterceptor;

    public SSOHandlerInterceptor getHandlerInterceptor() {
        if (handlerInterceptor == null) {
            return KissoDefaultHandler.getInstance();
        }
        return handlerInterceptor;
    }

    public void setHandlerInterceptor(SSOHandlerInterceptor handlerInterceptor) {
        this.handlerInterceptor = handlerInterceptor;
    }
}
