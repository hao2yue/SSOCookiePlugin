
package com.doctorai.kisso.common.captcha.color;

import java.awt.*;

/**
 * 单一颜色
 */
public class SingleColorFactory implements ColorFactory {

    private Color color;

    public SingleColorFactory() {
        color = Color.BLACK;
    }

    public SingleColorFactory(Color color) {
        this.color = color;
    }

    public Color getColor(int index) {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
