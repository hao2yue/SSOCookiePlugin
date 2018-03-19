
package com.zsh.kisso.exception;

/**
 * <p>
 * SSO 异常
 * </p>
 *
 * @author zhaoshihao
 * @since 2014-5-9
 */
public class KissoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public KissoException(String message) {
        super(message);
    }

    public KissoException(Throwable throwable) {
        super(throwable);
    }

    public KissoException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
