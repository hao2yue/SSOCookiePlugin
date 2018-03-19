
package com.zsh.kisso.common.captcha.filter.predefined;

import java.awt.image.BufferedImageOp;
import java.util.ArrayList;
import java.util.List;

import com.zsh.kisso.common.captcha.filter.AbstractFilterFactory;
import com.zsh.kisso.common.captcha.filter.library.DoubleRippleImageOp;

/**
 * 双波纹过滤器
 */
public class DoubleRippleFilterFactory extends AbstractFilterFactory {

    protected List<BufferedImageOp> filters;
    protected DoubleRippleImageOp ripple;

    public DoubleRippleFilterFactory() {
        ripple = new DoubleRippleImageOp();
    }

    @Override
    public List<BufferedImageOp> getFilters() {
        if (filters == null) {
            filters = new ArrayList<BufferedImageOp>();
            filters.add(ripple);
        }
        return filters;
    }

}
