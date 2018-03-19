
package com.doctorai.kisso.common.captcha.filter.predefined;

import java.awt.image.BufferedImageOp;
import java.util.ArrayList;
import java.util.List;

import com.doctorai.kisso.common.captcha.filter.library.DiffuseImageOp;

/**
 * 扩散波纹过滤器
 */
public class DiffuseRippleFilterFactory extends RippleFilterFactory {

    protected DiffuseImageOp diffuse = new DiffuseImageOp();

    @Override
    protected List<BufferedImageOp> getPreRippleFilters() {
        List<BufferedImageOp> list = new ArrayList<BufferedImageOp>();
        list.add(diffuse);
        return list;
    }
}
