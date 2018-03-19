
package com.doctorai.kisso.common.captcha.filter;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.util.List;

/**
 * 过滤器抽象工厂
 */
public abstract class AbstractFilterFactory implements FilterFactory {

    protected abstract List<BufferedImageOp> getFilters();

    public BufferedImage applyFilters(BufferedImage source) {
        BufferedImage dest = source;
        for (BufferedImageOp filter : getFilters()) {
            dest = filter.filter(dest, null);
        }
        int x = (source.getWidth() - dest.getWidth()) / 2;
        int y = (source.getHeight() - dest.getHeight()) / 2;
        source = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
        source.getGraphics().drawImage(dest, x, y, null);
        return source;
    }

}
