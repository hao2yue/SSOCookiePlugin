
package com.zsh.kisso.exception;

import com.zsh.kisso.security.token.Token;

/**
 * <p>
 * SSO Token 失效异常
 * </p>
 *
 * @author zhaoshihao
 * @since 2017-07-17
 */
public class ExpiredTokenException extends KissoException {

    private static final long serialVersionUID = -5959543783324224864L;

    private Token token;

    public ExpiredTokenException(String msg) {
        super(msg);
    }

    public ExpiredTokenException(Token token, String msg, Throwable t) {
        super(msg, t);
        this.token = token;
    }

    public String token() {
        return this.token.getToken();
    }
}
