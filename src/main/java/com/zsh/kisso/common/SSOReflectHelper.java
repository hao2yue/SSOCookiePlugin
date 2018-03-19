
package com.zsh.kisso.common;

import com.zsh.kisso.SSOAuthorization;
import com.zsh.kisso.SSOCache;
import com.zsh.kisso.SSOStatistic;
import com.zsh.kisso.common.auth.AuthDefaultImpl;
import com.zsh.kisso.common.encrypt.Algorithm;
import com.zsh.kisso.common.encrypt.SSOEncrypt;
import com.zsh.kisso.common.encrypt.SSOSymmetrical;
import com.zsh.kisso.common.parser.FastJsonParser;
import com.zsh.kisso.common.parser.SSOParser;
import com.zsh.kisso.exception.KissoException;
import com.zsh.kisso.security.token.SSOToken;
import com.zsh.kisso.security.token.Token;

/**
 * <p>
 * SSO 反射辅助类
 * </p>
 * 
 * @author zhaoshihao
 * @Date 2015-12-05
 */
public class SSOReflectHelper {

	private static SSOEncrypt encrypt = null;

	private static SSOCache cache = null;

	private static SSOStatistic statistic = null;

	private static SSOParser parser = null;

    private static SSOAuthorization authorization = null;
    
	/**
	 * <p>
	 * 反射获取自定义Token
	 * </p>
	 * 
	 * @return {@link Token}
	 */
	public static Token getConfigToken(String tokenClass ) {
		/**
		 * 判断是否自定义 Token 默认 SSOToken
		 */
		Token token = null;
		if ( tokenClass == null || "".equals(tokenClass) ) {
			token =  SSOToken.create();
		} else {
			try {
				Class<?> tc = Class.forName(tokenClass);
				if ( tc.newInstance() instanceof Token ) {
					token = (Token) tc.newInstance();
				}
			} catch ( Exception e ) {
				throw new KissoException(e);
			}
		}

		return token;
	}


	/**
	 * <p>
	 * 反射获取自定义SSOParser
	 * </p>
	 * 
	 * @return {@link Token}
	 */
	public static SSOParser getConfigParser( String parserClass ) {

		if ( parser != null ) {
			return parser;
		}

		/**
		 * 获取自定义 SSOParser
		 */
		if ( parserClass == null || "".equals(parserClass) ) {
			parser = new FastJsonParser();
		} else {
			try {
				Class<?> tc = Class.forName(parserClass);
				if ( tc.newInstance() instanceof SSOParser ) {
					parser = (SSOParser) tc.newInstance();
				}
			} catch ( Exception e ) {
				throw new KissoException(" kisso Config 【 sso.parser.class 】 not find. or not instanceof SSOParser", e);
			}
		}

		return parser;
	}


	public static void setConfigParser( SSOParser configParser ) {
		parser = configParser;
	}


	/**
	 * <p>
	 * 反射获取自定义Encrypt
	 * </p>
	 * 
	 * @return {@link Encrypt}
	 */
	public static SSOEncrypt getConfigEncrypt( String encryptClass, String encryptAlgorithm) {

		if ( encrypt != null ) {
			return encrypt;
		}

		/**
		 * 判断是否自定义 Encrypt 默认 RC4
		 */
		if ( encryptClass == null || "".equals(encryptClass) ) {
			encrypt = new SSOSymmetrical(Algorithm.convert(encryptAlgorithm));
		} else {
			try {
				Class<?> tc = Class.forName(encryptClass);
				if ( tc.newInstance() instanceof SSOEncrypt ) {
					encrypt = (SSOEncrypt) tc.newInstance();
				}
			} catch ( Exception e ) {
				throw new KissoException(e);
			}
		}

		return encrypt;
	}


	public static void setConfigEncrypt( SSOEncrypt configEncrypt ) {
		encrypt = configEncrypt;
	}


	/**
	 * <p>
	 * 反射获取自定义SSOCache
	 * </p>
	 * 
	 * @return {@link SSOCache}
	 */
	public static SSOCache getConfigCache( String cacheClass ) {

		if ( cache != null ) {
			return cache;
		}

		/**
		 * 反射获得缓存类
		 */
		if ( cacheClass != null && !"".equals(cacheClass) ) {
			try {
				Class<?> tc = Class.forName(cacheClass);
				if ( tc.newInstance() instanceof SSOCache ) {
					cache = (SSOCache) tc.newInstance();
				}
			} catch ( Exception e ) {
				throw new KissoException(e);
			}
		}
		return cache;
	}


	public static void setConfigCache( SSOCache configcache ) {
		cache = configcache;
	}


	/**
	 * 反射获取自定义SSOStatistic
	 * 
	 * @return {@link SSOStatistic}
	 */
	public static SSOStatistic getConfigStatistic(String encryptClass ) {

		if ( statistic != null ) {
			return statistic;
		}

		/**
		 * 反射获得统计类
		 */
		if ( encryptClass != null && !"".equals(encryptClass) ) {
			try {
				Class<?> tc = Class.forName(encryptClass);
				if ( tc.newInstance() instanceof SSOStatistic ) {
					statistic = (SSOStatistic) tc.newInstance();
				}
			} catch ( Exception e ) {
				throw new KissoException(e);
			}
		}

		return statistic;
	}


	public static void setConfigStatistic( SSOStatistic configStatistic ) {
		statistic = configStatistic;
	}


	/**
	 * 反射获取自定义SSOAuthorization
	 * 
	 * @return {@link SSOAuthorization}
	 */
	public static SSOAuthorization getAuthorization(String authorizationClass) {
		if ( authorization != null ) {
			return authorization;
		}

		/**
		 * 反射获得权限类
		 */
		if ( authorizationClass != null && !"".equals(authorizationClass) ) {
			try {
				Class<?> tc = Class.forName(authorizationClass);
				if ( tc.newInstance() instanceof SSOAuthorization ) {
					authorization = (SSOAuthorization) tc.newInstance();
				}
			} catch ( Exception e ) {
				throw new KissoException(e);
			}
		} else {
			authorization = new AuthDefaultImpl();
		}

		return authorization;
	}

	public static void setAuthorization(SSOAuthorization authorization) {
		SSOReflectHelper.authorization = authorization;
	}
	
}
