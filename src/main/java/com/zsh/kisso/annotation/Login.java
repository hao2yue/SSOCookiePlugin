
package com.zsh.kisso.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 方法注解
 * <p>
 * 不验证是否登录，忽略当前方法。
 * </p>
 *
 * @author zhaoshihao
 * @since 2015-11-10
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {

    /**
     * 执行动作
     * {@link Action}
     */
    Action action() default Action.Normal;

}
