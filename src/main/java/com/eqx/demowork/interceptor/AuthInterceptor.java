package com.eqx.demowork.interceptor;

import com.eqx.demowork.annotation.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Class cls = handler.getClass();
        if (cls.isAnnotationPresent(Auth.class)) {
            log.info(" 该访问路径 需要权限");
        } else {
            if (handler instanceof HandlerMethod) {
                HandlerMethod method = (HandlerMethod) handler;
                Auth methodAuth = method.getMethodAnnotation(Auth.class);
                if (methodAuth != null) {
                    log.info(" 该访问路径 需要权限");
                } else {
                    log.info(" 该访问路径不需要权限");
                }
            }
        }
        return true;
    }
}
