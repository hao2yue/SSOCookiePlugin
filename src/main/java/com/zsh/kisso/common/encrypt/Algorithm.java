
package com.zsh.kisso.common.encrypt;

/**
 * <p>
 * 算法类型枚举类
 * </p>
 *
 * @author zhaoshihao
 * @since 2016-01-20
 */
public enum Algorithm {
    DES("DES", "DES encrypt"),
    AES("AES", "AES encrypt"),
    BLOWFISH("BLOWFISH", "Blowfish encrypt"),
    RC2("RC2", "RC2 encrypt"),
    RC4("RC4", "RC4 encrypt");

    /** 主键 */
    private final String key;

    /** 描述 */
    private final String desc;

    Algorithm(final String key, final String desc) {
        this.key = key;
        this.desc = desc;
    }

    public String getKey() {
        return this.key;
    }

    public String getDesc() {
        return this.desc;
    }

    public static Algorithm convert(String encryptAlgorithm) {
        Algorithm algorithm = Algorithm.RC4;
        if (null != encryptAlgorithm) {
            Algorithm[] algs = Algorithm.values();
            for (Algorithm alg : algs) {
                if (alg.getKey().equals(encryptAlgorithm)) {
                    algorithm = alg;
                    break;
                }
            }
        }
        return algorithm;
    }

}
