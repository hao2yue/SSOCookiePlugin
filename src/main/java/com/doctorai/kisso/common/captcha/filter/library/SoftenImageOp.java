
package com.doctorai.kisso.common.captcha.filter.library;

/**
 * 图片软化
 */
public class SoftenImageOp extends AbstractConvolveImageOp {

    private static final float[][] matrix = {{0 / 16f, 1 / 16f, 0 / 16f},
            {1 / 16f, 12 / 16f, 1 / 16f}, {0 / 16f, 1 / 16f, 0 / 16f}};

    public SoftenImageOp() {
        super(matrix);
    }

}
