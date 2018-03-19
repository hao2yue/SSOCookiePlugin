
package com.zsh.kisso.common.captcha.filter.predefined;

import java.awt.image.BufferedImageOp;
import java.util.ArrayList;
import java.util.List;

import com.zsh.kisso.common.captcha.filter.AbstractFilterFactory;
import com.zsh.kisso.common.captcha.filter.library.RippleImageOp;

/**
 * 波纹过滤器
 */
public class RippleFilterFactory extends AbstractFilterFactory {

    protected List<BufferedImageOp> filters;
    protected RippleImageOp ripple;

    public RippleFilterFactory() {
        ripple = new RippleImageOp();
    }

    protected List<BufferedImageOp> getPreRippleFilters() {
        return new ArrayList<BufferedImageOp>();
    }

    protected List<BufferedImageOp> getPostRippleFilters() {
        return new ArrayList<BufferedImageOp>();

    }

    @Override
    public List<BufferedImageOp> getFilters() {
        if (filters == null) {
            filters = new ArrayList<BufferedImageOp>();
            filters.addAll(getPreRippleFilters());
            filters.add(ripple);
            filters.addAll(getPostRippleFilters());
        }
        return filters;
    }


}
