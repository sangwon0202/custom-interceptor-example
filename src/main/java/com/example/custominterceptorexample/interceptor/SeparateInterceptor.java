package com.example.custominterceptorexample.interceptor;

import com.example.custominterceptorexample.customInterceptor.CustomInterceptor;
import com.example.custominterceptorexample.customInterceptor.InterceptorConfigurer;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class SeparateInterceptor implements CustomInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("인터셉터 체인 시작");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("인터셉터 체인 끝");
    }

    @Override
    public void configure(InterceptorConfigurer interceptorConfigurer) {
        interceptorConfigurer
                .addPathPatterns("/**")
                .order(1);
    }
}
