package com.eqx.demowork.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;

@Component
@Slf4j
public class LogInterceptor extends HandlerInterceptorAdapter {

    private ThreadLocal<Long> beginTime = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        beginTime.set(System.currentTimeMillis());

        StringBuilder sb = new StringBuilder();
        for (String key : request.getParameterMap().keySet()) {
            sb.append(key).append("=").append(request.getParameterValues(key)[0]).append("，");
        }

//        BufferedReader br = request.getReader();
//        String str;
//        while ((str = br.readLine()) != null) {
//            sb.append(str).append("=");
//        }

        log.info("Request URI: {}, data: {}", request.getRequestURI(), sb.toString());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("Request URI: {}, 耗时: {} ms", request.getRequestURI(), System.currentTimeMillis() - beginTime.get());
    }
}
