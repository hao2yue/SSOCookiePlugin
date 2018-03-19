
package com.zsh.kisso.web.waf.attack;

/**
 * 攻击过滤父类
 * <p>
 * @author zhaoshihao
 * @since 2014-12-08
 */
public interface Istrip {

    /**
     * @Description 脚本内容剥离
     * @param value
     * 				待处理内容
     * @return
     */
    public String strip(String value);
}
