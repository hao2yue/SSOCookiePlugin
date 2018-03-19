
package com.doctorai.kisso.common.parser;


import com.alibaba.fastjson.JSON;

/**
 * <p>
 * SSO Token 解析接口
 * </p>
 * 
 * @author zhaoshihao
 * @Date 2014-5-9
 */
public class FastJsonParser implements SSOParser {

	public String toJson(Object token) {
		return JSON.toJSONString(token);
	}

	public <T> T parseObject(String text, Class<? extends T> clazz) {
		return JSON.parseObject(text, clazz);
	}
	
}
