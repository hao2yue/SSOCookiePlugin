
package com.zsh.kisso.common.captcha.filter;

import java.awt.image.BufferedImage;

/**
 * 过滤器接口
 */
public interface FilterFactory {

    BufferedImage applyFilters(BufferedImage source);

}
