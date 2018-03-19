
package com.doctorai.kisso.enums;

/**
 * <p>
 * Token 状态标记
 * </p>
 *
 * @author zhaoshihao
 * @since 2017-08-07
 */
public enum TokenFlag {
    NORMAL("0", "正常"),
    CACHE_SHUT("1", "缓存宕机");

    /**
     * 主键
     */
    private final String value;

    /**
     * 描述
     */
    private final String desc;

    TokenFlag(final String value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static TokenFlag fromValue(String value) {
        TokenFlag[] its = TokenFlag.values();
        for (TokenFlag it : its) {
            if (it.value() == value) {
                return it;
            }
        }
        return NORMAL;
    }

    public String value() {
        return this.value;
    }

    public String desc() {
        return this.desc;
    }

}
