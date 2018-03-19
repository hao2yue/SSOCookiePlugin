
package com.doctorai.kisso.common.util;

import com.doctorai.kisso.SSOConfig;
import com.doctorai.kisso.common.encrypt.base64.Base64;
import com.doctorai.kisso.common.encrypt.base64.UrlBase64;

/**
 * <p>
 * BASE64编码解码工具包
 * </p>
 * <p>
 * 依赖bcprov-jdk14-1.48.jar
 * </p>
 *
 * @author zhaoshihao
 * @since 2014-6-17
 */
public class Base64Util {

    /**
     * <p>
     * BASE64字符串解码为二进制数据
     * </p>
     *
     * @param base64
     * @return
     * @throws Exception
     */
    public static byte[] decode(String base64) throws Exception {
        return Base64.decode(base64.getBytes());
    }

    /**
     * <p>
     * 二进制数据编码为BASE64字符串
     * </p>
     *
     * @param bytes
     * @return
     * @throws Exception
     */
    public static String encode(byte[] bytes) throws Exception {
        return new String(Base64.encode(bytes));
    }

    /**
     * BASE64 encrypt
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key) throws Exception {
        byte[] b = UrlBase64.encode(key);
        return new String(b, SSOConfig.getSSOEncoding());
    }

    /**
     * BASE64 decrypt
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptBASE64(String key) throws Exception {
        return UrlBase64.decode(key.getBytes(SSOConfig.getSSOEncoding()));
    }

}
