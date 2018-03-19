
package com.doctorai.kisso.common.captcha.text.renderer;

import java.awt.image.BufferedImage;

import com.doctorai.kisso.common.captcha.color.ColorFactory;
import com.doctorai.kisso.common.captcha.font.FontFactory;

/**
 * 文本渲染接口
 */
public interface TextRenderer {

    void setLeftMargin(int leftMargin);

    void setRightMargin(int rightMargin);

    void setTopMargin(int topMargin);

    void setBottomMargin(int bottomMargin);

    void draw(String text, BufferedImage canvas, FontFactory fontFactory, ColorFactory colorFactory);

}
