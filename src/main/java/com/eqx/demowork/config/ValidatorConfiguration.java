package com.eqx.demowork.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @Author duan
 * @Description: 参数校验配置
 *  1、验证请求参数时，在@RequestBody 和实体类之间加注解 @Valid，然后后面加BindindResult即可
 *  如：
 *      public void test()(@RequestBody @Valid DemoModel demo, BindingResult result)
 *      public void test()(@RequestBody @Valid DemoModel demo, BindingResult result,@RequestBody @Valid DemoModel demo2, BindingResult result2)
 *
 * @URL: https://www.cnblogs.com/mr-yang-localhost/p/7812038.html
 * @Date: Created in 下午4:28 2018/4/11
 */
@Configuration
public class ValidatorConfiguration {

    @Bean
    public Validator validator() {
        ValidatorFactory factory = Validation.byProvider(HibernateValidator.class)
                .configure()
                // true  快速失败返回模式(只要有一个验证失败，则返回)    false 普通模式(会校验完所有的属性，然后返回所有的验证失败信息)
                .failFast(true)
                .buildValidatorFactory();
        return factory.getValidator();
    }

    /**
     *  使用@Valid注解，对RequestParam对应的参数进行注解，是无效的，需要使用@Validated注解来使得验证生效
     *  或者
     *  添加此bean并且在方法所在的Controller上加注解@Validated
     * @return
     */
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
        /**设置validator模式为快速失败返回*/
        postProcessor.setValidator(validator());
        return postProcessor;
    }
}
