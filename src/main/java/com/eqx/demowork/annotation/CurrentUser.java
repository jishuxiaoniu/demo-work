package com.eqx.demowork.annotation;

import java.lang.annotation.*;

/**
 * @Author duan
 * @Description: 参数绑定注解
 * @Date: Created in 上午10:54 2018/5/18
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {

    String value() default "";
}
