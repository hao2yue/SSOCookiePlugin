
package com.doctorai.kisso.web.waf;

import com.doctorai.kisso.web.waf.attack.SqlInjection;
import com.doctorai.kisso.web.waf.attack.XSS;

/**
 * Web防火墙工具类
 * <p>
 * @author zhaoshihao
 * @since 2014-5-8
 */
public class WafHelper {

    /**
     * @Description 过滤XSS脚本内容
     * @param value
     * 				待处理内容
     * @return
     */
    public static String stripXSS(String value) {
        if (value == null) {
            return null;
        }

        return new XSS().strip(value);
    }

    /**
     * @Description 过滤SQL注入内容
     * @param value
     * 				待处理内容
     * @return
     */
    public static String stripSqlInjection(String value) {
        if (value == null) {
            return null;
        }

        return new SqlInjection().strip(value);
    }

    /**
     * @Description 过滤SQL/XSS注入内容
     * @param value
     * 				待处理内容
     * @return
     */
    public static String stripSqlXSS(String value) {
        if (value == null) {
            return null;
        }

        return stripXSS(stripSqlInjection(value));
    }

}
