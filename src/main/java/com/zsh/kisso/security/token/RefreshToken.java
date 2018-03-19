
package com.zsh.kisso.security.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

/**
 * <p>
 * JWT 刷新票据
 * </p>
 *
 * @author zhaoshihao
 * @since 2017-07-17
 */
public class RefreshToken implements Token {

    private Jws<Claims> claims;

    private RefreshToken(Jws<Claims> claims) {
        this.claims = claims;
    }

    @Override
    public String getToken() {
        return null;
    }

    public Jws<Claims> getClaims() {
        return claims;
    }

    public String getJti() {
        return claims.getBody().getId();
    }

    public String getSubject() {
        return claims.getBody().getSubject();
    }
}
