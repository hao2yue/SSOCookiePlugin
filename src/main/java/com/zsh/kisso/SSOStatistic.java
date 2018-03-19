
package com.zsh.kisso;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * SSO 在线人数统计接口
 * </p>
 * 
 * @author zhaoshihao
 * @Date 2015-11-17
 */
public interface SSOStatistic {

	/**
	 * 在线人数 +1
	 * 
	 * @param request
	 *            登录请求
	 * @return boolean
	 */
	boolean increase(HttpServletRequest request);

	/**
	 * 在线人数 -1
	 * 
	 * @param request
	 *            退出请求
	 * @return boolean
	 */
	boolean decrease(HttpServletRequest request);

	/**
	 * 在线人数（总数）
	 * 
	 * @param request
	 *            查询请求
	 * @return String
	 */
	String count(HttpServletRequest request);

}
