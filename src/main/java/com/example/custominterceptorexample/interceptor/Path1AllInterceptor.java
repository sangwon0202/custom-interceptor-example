package com.example.custominterceptorexample.interceptor;

import com.example.custominterceptorexample.customInterceptor.CustomInterceptor;
import com.example.custominterceptorexample.customInterceptor.InterceptorConfigurer;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Path1AllInterceptor implements CustomInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("path1 모든 요청");
        return true;
    }

    @Override
    public void configure(InterceptorConfigurer interceptorConfigurer) {
        interceptorConfigurer
                .addPathPatterns("/path1")
                .order(2);
    }
}
