
package com.doctorai.kisso.common;

import java.nio.charset.Charset;

/**
 * <p>
 * SSO 定义常量
 * </p>
 *
 * @author zhaoshihao
 * @since 2017-07-17
 */
public interface SSOConstants {

    String ENCODING = "UTF-8";
    String TOKEN_USER_IP = "ip";
    String TOKEN_USER_AGENT = "ua";
    String TOKEN_FLAG = "fg";
    String TOKEN_ORIGIN = "og";
    String SIGN_RSA = "RSA"; // RSA 签名算法

    /**
     * <p>
     * 拦截器判断后设置 Token至当前请求<br>
     * 减少Token解密次数： request.setAttribute("ssotoken_attr", token)
     * </p>
     * <p>
     * 使用获取方式： SSOHelper.attrToken(request)
     * </p>
     */
    String SSO_TOKEN_ATTR = "kissoTokenAttr";

    /**
     * 踢出用户逻辑标记
     */
    String SSO_KICK_FLAG = "kissoKickFlag";
    String SSO_KICK_USER = "kissoKickUser";

    /**
     * SSO 动态设置 Cookie 参数
     * <p>
     * -1 浏览器关闭时自动删除 0 立即删除 120 表示Cookie有效期2分钟(以秒为单位)
     * </p>
     */
    String SSO_COOKIE_MAXAGE = "kisso_cookie_maxage";

    /**
     * Charset 类型编码格式
     */
    Charset CHARSET_ENCODING = Charset.forName(ENCODING);

    String CUT_SYMBOL = "#";


}
