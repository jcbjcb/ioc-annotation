package com.jcb.annotations.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: deu
 * @description: 实现bean实例化注解
 * @author: jcb
 * @create: 2018-07-16 19:42
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Bean {

    String value() default "";

    String targetName() default "";
}
