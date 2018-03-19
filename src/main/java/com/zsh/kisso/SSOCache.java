
package com.zsh.kisso;

import com.zsh.kisso.security.token.SSOToken;

/**
 * <p>
 * SSO 缓存接口
 * </p>
 *
 * @author zhaoshihao
 * @since 2015-11-03
 */
public interface SSOCache {

    /**
     * <p>
     * 根据key获取SSO票据
     * </p>
     * <p>
     * 如果缓存服务宕机，返回 token 设置 flag 为 Token.FLAG_CACHE_SHUT
     * </p>
     *
     * @param key     关键词
     * @param expires 过期时间（延时心跳时间）
     * @return SSO票据
     */
    SSOToken get(String key, int expires);

    /**
     * 设置SSO票据
     *
     * @param key      关键词
     * @param ssoToken SSO票据
     * @param expires  过期时间
     */
    boolean set(String key, SSOToken ssoToken, int expires);

    /**
     * 删除SSO票据
     * <p>
     *
     * @param key 关键词
     */
    boolean delete(String key);

}
