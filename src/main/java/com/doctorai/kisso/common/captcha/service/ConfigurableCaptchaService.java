
package com.doctorai.kisso.common.captcha.service;

import com.doctorai.kisso.common.captcha.background.SingleColorBackgroundFactory;
import com.doctorai.kisso.common.captcha.color.SingleColorFactory;
import com.doctorai.kisso.common.captcha.filter.predefined.CurvesRippleFilterFactory;
import com.doctorai.kisso.common.captcha.font.RandomFontFactory;
import com.doctorai.kisso.common.captcha.font.UpperRandomWordFactory;
import com.doctorai.kisso.common.captcha.text.renderer.BestFitTextRenderer;

/**
 * 默认配置验证码服务
 */
public class ConfigurableCaptchaService extends AbstractCaptchaService {

    public ConfigurableCaptchaService() {
        backgroundFactory = new SingleColorBackgroundFactory();
        wordFactory = new UpperRandomWordFactory();
        fontFactory = new RandomFontFactory();
        textRenderer = new BestFitTextRenderer();
        colorFactory = new SingleColorFactory();
        filterFactory = new CurvesRippleFilterFactory(colorFactory);
        textRenderer.setLeftMargin(10);
        textRenderer.setRightMargin(10);
        width = 160;
        height = 70;
    }

}
