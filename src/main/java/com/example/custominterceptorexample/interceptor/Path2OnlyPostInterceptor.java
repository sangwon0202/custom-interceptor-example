package com.example.custominterceptorexample.interceptor;

import com.example.custominterceptorexample.customInterceptor.CustomInterceptor;
import com.example.custominterceptorexample.customInterceptor.HttpMethod;
import com.example.custominterceptorexample.customInterceptor.InterceptorConfigurer;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Path2OnlyPostInterceptor implements CustomInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("path2 POST만");
        return true;
    }

    @Override
    public void configure(InterceptorConfigurer interceptorConfigurer) {
        interceptorConfigurer
                .addPathPatterns("/path2", HttpMethod.POST)
                .order(3);
    }
}