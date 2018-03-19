
package com.doctorai.kisso.common.parser;

/**
 * <p>
 * SSO Token 解析接口
 * </p>
 * 
 * @author zhaoshihao
 * @Date 2014-5-9
 */
public interface SSOParser {

	/**
	 * Object 对象转换为 json 字符串
	 * 
	 * @param obj
	 *            转换对象
	 * @return
	 */
	String toJson(Object obj);

	/**
	 * json 格式字符串转换为 T 对象
	 * 
	 * @param <T>
	 * 
	 * @param <T>
	 * @param text
	 *            json 字符串
	 * @param clazz
	 *            Object 对象类
	 * @return
	 */
	<T> T parseObject(String text, Class<? extends T> clazz);
}
