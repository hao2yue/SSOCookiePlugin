
package com.zsh.kisso.common.captcha.filter.library;

/**
 * 图片模糊
 */
public class BlurImageOp extends AbstractConvolveImageOp {

    private static final float[][] matrix = {{1 / 16f, 2 / 16f, 1 / 16f},
            {2 / 16f, 4 / 16f, 2 / 16f}, {1 / 16f, 2 / 16f, 1 / 16f}};

    public BlurImageOp() {
        super(matrix);
    }

}
