
package com.doctorai.kisso.common.captcha.filter;

import java.awt.image.BufferedImageOp;
import java.util.List;

/**
 * 配置过滤器工厂
 */
public class ConfigurableFilterFactory extends AbstractFilterFactory {

    private List<BufferedImageOp> filters;

    @Override
    public List<BufferedImageOp> getFilters() {
        return filters;
    }

    public void setFilters(List<BufferedImageOp> filters) {
        this.filters = filters;
    }

}
