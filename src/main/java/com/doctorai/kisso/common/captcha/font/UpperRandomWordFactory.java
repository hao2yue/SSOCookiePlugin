
package com.doctorai.kisso.common.captcha.font;

import java.util.Random;

import com.doctorai.kisso.common.captcha.word.RandomWordFactory;

/**
 * 随机字符大小写
 */
public class UpperRandomWordFactory extends RandomWordFactory {

    /**
     * 重载父类获取字符方法
     * 支持随机大小写字符
     */
    @Override
    public String getNextWord() {
        Random rnd = new Random();
        StringBuffer sb = new StringBuffer();
        int l = this.minLength + (this.maxLength > this.minLength ? rnd.nextInt(this.maxLength - this.minLength) : 0);
        for (int i = 0; i < l; i++) {
            int j = rnd.nextInt(this.characters.length());
            if (rnd.nextBoolean()) {
                sb.append(this.characters.toUpperCase().charAt(j));
            } else {
                sb.append(this.characters.charAt(j));
            }
        }
        return sb.toString();
    }
}
