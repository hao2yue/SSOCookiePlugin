
package com.doctorai.kisso.service;

import com.doctorai.kisso.SSOConfig;

/**
 * <p>
 * SSO 单点登录服务抽象实现类
 * </p>
 *
 * @author zhaoshihao
 * @since 2015-12-03
 */
public class ConfigurableAbstractKissoService extends AbstractKissoService {

    public ConfigurableAbstractKissoService() {
        config = SSOConfig.getInstance();
    }
}
