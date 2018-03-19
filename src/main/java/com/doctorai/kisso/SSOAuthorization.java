
package com.doctorai.kisso;

import com.doctorai.kisso.security.token.Token;

/**
 * <p>
 * SSO 权限授权接口
 * </p>
 * 
 * @author zhaoshihao
 * @Date 2016-04-03
 */
public interface SSOAuthorization {

	boolean isPermitted(Token token, String permission);

}
