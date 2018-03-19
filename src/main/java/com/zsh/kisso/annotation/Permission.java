
package com.zsh.kisso.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * kisso 权限注解
 * </p>
 *
 * @author zhaoshihao
 * @since 2016-03-07
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Permission {

    /**
     * 权限内容
     */
    String value() default "";

    /**
     * 执行动作
     * {@link Action}
     */
    Action action() default Action.Normal;

}
