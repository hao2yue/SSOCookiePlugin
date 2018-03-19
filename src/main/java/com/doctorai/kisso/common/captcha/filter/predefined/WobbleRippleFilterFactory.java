
package com.doctorai.kisso.common.captcha.filter.predefined;

import java.awt.image.BufferedImageOp;
import java.util.ArrayList;
import java.util.List;

import com.doctorai.kisso.common.captcha.filter.library.WobbleImageOp;

/**
 * 摆动波纹过滤器
 */
public class WobbleRippleFilterFactory extends RippleFilterFactory {

    protected WobbleImageOp wobble;

    public WobbleRippleFilterFactory() {
        wobble = new WobbleImageOp();
    }

    @Override
    protected List<BufferedImageOp> getPreRippleFilters() {
        List<BufferedImageOp> list = new ArrayList<BufferedImageOp>();
        list.add(wobble);
        return list;
    }

}
