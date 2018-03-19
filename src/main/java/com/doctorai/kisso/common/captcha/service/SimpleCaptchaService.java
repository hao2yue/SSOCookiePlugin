
package com.doctorai.kisso.common.captcha.service;

import java.awt.*;

import com.doctorai.kisso.common.captcha.background.SingleColorBackgroundFactory;
import com.doctorai.kisso.common.captcha.color.SingleColorFactory;
import com.doctorai.kisso.common.captcha.filter.FilterFactory;
import com.doctorai.kisso.common.captcha.font.RandomFontFactory;
import com.doctorai.kisso.common.captcha.text.renderer.BestFitTextRenderer;
import com.doctorai.kisso.common.captcha.word.AdaptiveRandomWordFactory;

/**
 * 简单验证码服务
 */
public class SimpleCaptchaService extends AbstractCaptchaService {

    public SimpleCaptchaService(int width, int height, Color textColor, Color backgroundColor, int fontSize, FilterFactory ff) {
        backgroundFactory = new SingleColorBackgroundFactory(backgroundColor);
        wordFactory = new AdaptiveRandomWordFactory();
        fontFactory = new RandomFontFactory();
        textRenderer = new BestFitTextRenderer();
        colorFactory = new SingleColorFactory(textColor);
        filterFactory = ff;
        this.width = width;
        this.height = height;
    }

    public SimpleCaptchaService(int width, int height, Color textColor, Color backgroundColor, int fontSize, String[] fontNames, FilterFactory ff) {
        backgroundFactory = new SingleColorBackgroundFactory(backgroundColor);
        wordFactory = new AdaptiveRandomWordFactory();
        fontFactory = new RandomFontFactory(fontNames);
        textRenderer = new BestFitTextRenderer();
        colorFactory = new SingleColorFactory(textColor);
        filterFactory = ff;
        this.width = width;
        this.height = height;
    }

    @Override
    public Captcha getCaptcha() {
        return null;
    }

}
