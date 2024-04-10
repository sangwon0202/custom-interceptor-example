package com.example.custominterceptorexample.interceptor;

import com.example.custominterceptorexample.customInterceptor.CustomInterceptor;
import com.example.custominterceptorexample.customInterceptor.InterceptorConfigurer;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Annotation2Interceptor implements CustomInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("어노테이션 2");
        return true;
    }

    @Override
    public void configure(InterceptorConfigurer interceptorConfigurer) {
        interceptorConfigurer.order(5);
    }
}
