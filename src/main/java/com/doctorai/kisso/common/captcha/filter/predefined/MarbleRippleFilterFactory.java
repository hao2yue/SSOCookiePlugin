
package com.doctorai.kisso.common.captcha.filter.predefined;

import java.awt.image.BufferedImageOp;
import java.util.ArrayList;
import java.util.List;

import com.doctorai.kisso.common.captcha.filter.library.MarbleImageOp;

/**
 * 大理石波纹过滤器
 */
public class MarbleRippleFilterFactory extends RippleFilterFactory {

    protected MarbleImageOp marble = new MarbleImageOp();

    @Override
    protected List<BufferedImageOp> getPreRippleFilters() {
        List<BufferedImageOp> list = new ArrayList<BufferedImageOp>();
        list.add(marble);
        return list;
    }

}

