package com.example.custominterceptorexample.customInterceptor;

import org.springframework.web.servlet.HandlerInterceptor;

public interface CustomInterceptor extends HandlerInterceptor {


    void configure(InterceptorConfigurer interceptorConfigurer);

}
