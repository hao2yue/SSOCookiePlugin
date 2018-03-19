
package com.doctorai.kisso.common.encrypt;

/**
 * <p>
 * SSO 对称加密接口
 * </p>
 *
 * @author zhaoshihao
 * @since 2014-5-9
 */
public interface SSOEncrypt {

    /**
     * 字符串内容加密
     * <p>
     *
     * @param value
     *            加密内容
     * @param key
     *            密钥
     * @return
     * @throws Exception
     */
    String encrypt(String value, String key) throws Exception;

    /**
     * 字符串内容解密
     * <p>
     *
     * @param value
     *            解密内容
     * @param key
     *            密钥
     * @return
     * @throws Exception
     */
    String decrypt(String value, String key) throws Exception;
}
