
package com.zsh.kisso.common.captcha.background;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 线形噪点干扰背景
 */
public class LineNoiseBackgroundFactory implements BackgroundFactory {

    private static final Random rand = new Random();

    /** 噪点数量 */
    private int noises = 20;

    public LineNoiseBackgroundFactory() {

    }

    public LineNoiseBackgroundFactory(int noises) {
        this.noises = noises;
    }

    public void fillBackground(BufferedImage image) {
        Graphics graphics = image.getGraphics();

        //验证码图片的宽高
        int imgWidth = image.getWidth();
        int imgHeight = image.getHeight();

        //填充为白色背景
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, imgWidth, imgHeight);

        /**
         * 画100个噪点(颜色及位置随机)
         */
        for (int i = 0; i < getNoises(); i++) {
            //随机颜色
            int rInt = rand.nextInt(255);
            int gInt = rand.nextInt(255);
            int bInt = rand.nextInt(255);

            graphics.setColor(new Color(rInt, gInt, bInt));

            //随机位置
            int xInt = rand.nextInt(imgWidth - 3);
            int yInt = rand.nextInt(imgHeight - 2);

            //随机旋转角度
            int sAngleInt = rand.nextInt(60);
            int eAngleInt = rand.nextInt(360);

            //随机大小
            int wInt = rand.nextInt(6);
            int hInt = rand.nextInt(6);

            graphics.fillArc(xInt, yInt, wInt, hInt, sAngleInt, eAngleInt);

            //画5条干扰线
            if (i % 20 == 0) {
                int xInt2 = rand.nextInt(imgWidth);
                int yInt2 = rand.nextInt(imgHeight);
                graphics.drawLine(xInt, yInt, xInt2, yInt2);
            }
        }
    }

    public int getNoises() {
        return noises;
    }

    public void setNoises(int noises) {
        this.noises = noises;
    }
}
