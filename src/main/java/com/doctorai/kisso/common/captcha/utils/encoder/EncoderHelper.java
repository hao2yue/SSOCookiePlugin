
package com.doctorai.kisso.common.captcha.utils.encoder;

import javax.imageio.ImageIO;

import com.doctorai.kisso.common.captcha.service.Captcha;
import com.doctorai.kisso.common.captcha.service.CaptchaService;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 验证码编码辅助类
 */
public class EncoderHelper {

    public static String getChallangeAndWriteImage(CaptchaService service, String format, OutputStream os) throws IOException {
        Captcha captcha = service.getCaptcha();
        ImageIO.write(captcha.getImage(), format, os);
        return captcha.getChallenge();
    }

}

