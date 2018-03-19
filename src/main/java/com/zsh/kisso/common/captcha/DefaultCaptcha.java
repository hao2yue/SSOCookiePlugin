
package com.zsh.kisso.common.captcha;

import com.zsh.kisso.common.captcha.service.AbstractCaptchaService;
import com.zsh.kisso.common.captcha.service.ConfigurableCaptchaService;
import com.zsh.kisso.common.captcha.utils.encoder.EncoderHelper;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.OutputStream;

/**
 * <p>
 * 默认图片验证码实现
 * </p>
 *
 * @author zhaoshihao
 * @since 2016-08-13
 */
public class DefaultCaptcha extends AbstractCaptcha {

    /*
     * 抽象验证码服务
     */
    private AbstractCaptchaService captchaService;

    /*
     * 图片格式，默认 png
     */
    private String format = "png";

    @Override
    public String writeImage(HttpServletRequest request, OutputStream out) {
        if (captchaService == null) {
            captchaService = new ConfigurableCaptchaService();
        }
        try {
            return EncoderHelper.getChallangeAndWriteImage(captchaService, format, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public AbstractCaptchaService getCaptchaService() {
        return captchaService;
    }

    public void setCaptchaService(AbstractCaptchaService captchaService) {
        this.captchaService = captchaService;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

}
