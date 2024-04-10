package com.example.custominterceptorexample.customInterceptor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomInterceptorRegistry {

    private final List<CustomInterceptor> customInterceptors;

    public void addInterceptorsAuto(InterceptorRegistry registry) {
        for(CustomInterceptor interceptor : customInterceptors) {
            MethodPathMatcher methodPathMatcher = new MethodPathMatcher();
            OrderSetter orderSetter = new OrderSetter();
            InterceptorConfigurer interceptorConfigurer = new InterceptorConfigurer(methodPathMatcher, orderSetter);
            interceptor.configure(interceptorConfigurer);
            OuterInterceptor outerInterceptor = new OuterInterceptor(interceptor, methodPathMatcher);
            orderSetter.setRegistrationOrder(registry.addInterceptor(outerInterceptor).addPathPatterns("/**"));
        }
    }
}
