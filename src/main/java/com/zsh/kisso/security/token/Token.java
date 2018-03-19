
package com.zsh.kisso.security.token;

/**
 * <p>
 * SSO Token 票据
 * </p>
 *
 * @author zhaoshihao
 * @since 2017-07-17
 */
public interface Token {

    String getToken(); // 生成 Token 字符串
}
