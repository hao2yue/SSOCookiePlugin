
package com.zsh.kisso.common.auth;

import com.zsh.kisso.SSOAuthorization;
import com.zsh.kisso.security.token.Token;

/**
 * <p>
 * 用户不自定义权限，默认用此类来代替
 * </p>
 *
 * @author zhaoshihao
 * @since 2016-12-15
 */
public class AuthDefaultImpl implements SSOAuthorization {
    @Override
    public boolean isPermitted(Token token, String permission) {
        return true;
    }
}
