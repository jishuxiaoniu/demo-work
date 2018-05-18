package com.eqx.demowork.config;

import com.eqx.demowork.annotation.CurrentUser;
import com.eqx.demowork.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @Author duan
 * @Description: 自定义参数解析器
 *
 * 如果想要该配置生效，1：需要建一个配置类继承 WebMvcConfigurerAdapter 类，实现 addArgumentResolvers 接口
 *                  2：如果项目为springboot，可直接由启动类继承 WebMvcConfigurationSupport ，重写 addArgumentResolvers 方法
 *
 * @Date: Created in 上午10:56 2018/5/18
 */
@Configuration
public class CurrentUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // 当方法中参数添加 CurrentUser.class 注解时才会返回ture，只有返回true时才会执行下面的 resolveArgument 方法, 将返回的对象映射到该参数上
        return parameter.hasParameterAnnotation(CurrentUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        User user = new User();
        user.setId(1);
        user.setAge(1);
        user.setAddress("1");
        user.setName("1");
        return user;
    }
}
