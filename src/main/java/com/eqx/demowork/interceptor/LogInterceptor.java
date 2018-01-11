package com.eqx.demowork.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class LogInterceptor extends HandlerInterceptorAdapter {

    long beginTime;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String addr = request.getRemoteAddr();
        StringBuilder sb = new StringBuilder();
        for (String key : request.getParameterMap().keySet()) {
            sb.append(key).append(":").append(request.getParameterValues(key)[0]).append(";");
        }
        log.info("Request URI: {}, data: {}", request.getRequestURI(), sb.toString());
        beginTime = System.currentTimeMillis();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("Request URI: {}, 耗时: {} ms", request.getRequestURI(), System.currentTimeMillis() - beginTime);
    }
}
