
package com.zsh.kisso.security.token;

import io.jsonwebtoken.JwtBuilder;

/**
 * <p>
 * JWT 访问票据
 * </p>
 *
 * @author zhaoshihao
 * @since 2017-07-17
 */
public class AccessToken implements Token {

    private String token;

    public AccessToken() {
        // TO DO NOTHING
    }

    public AccessToken(JwtBuilder jwtBuilder) {
        this.token = jwtBuilder.compact();
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String getToken() {
        return this.token;
    }
}
