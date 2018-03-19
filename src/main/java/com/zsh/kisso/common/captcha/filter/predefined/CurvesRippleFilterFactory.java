
package com.zsh.kisso.common.captcha.filter.predefined;

import java.awt.image.BufferedImageOp;
import java.util.ArrayList;
import java.util.List;

import com.zsh.kisso.common.captcha.color.ColorFactory;
import com.zsh.kisso.common.captcha.filter.library.CurvesImageOp;

/**
 * 曲线波纹过滤器
 */
public class CurvesRippleFilterFactory extends RippleFilterFactory {

    protected CurvesImageOp curves = new CurvesImageOp();

    public CurvesRippleFilterFactory() {
    }

    public CurvesRippleFilterFactory(ColorFactory colorFactory) {
        setColorFactory(colorFactory);
    }

    @Override
    protected List<BufferedImageOp> getPreRippleFilters() {
        List<BufferedImageOp> list = new ArrayList<BufferedImageOp>();
        list.add(curves);
        return list;
    }

    public void setStrokeMin(float strokeMin) {
        curves.setStrokeMin(strokeMin);
    }

    public void setStrokeMax(float strokeMax) {
        curves.setStrokeMax(strokeMax);
    }

    public void setColorFactory(ColorFactory colorFactory) {
        curves.setColorFactory(colorFactory);
    }

}
