package com.example.custominterceptorexample.customInterceptor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InterceptorConfigurer {

    private final MethodPathMatcher methodPathMatcher;
    private final OrderSetter orderSetter;

    public InterceptorConfigurer order(int order) {
        orderSetter.setOrder(order);
        return this;
    }

    public InterceptorConfigurer addPathPatterns(String pattern) {
        return addPathPatterns(pattern, HttpMethod.ALL);
    }

    public InterceptorConfigurer excludePathPatterns(String pattern) {
        return excludePathPatterns(pattern, HttpMethod.ALL);
    }

    public InterceptorConfigurer addPathPatterns(String pattern, HttpMethod httpMethod) {
        methodPathMatcher.addPathPatterns(pattern, httpMethod);
        return this;
    }

    public InterceptorConfigurer excludePathPatterns(String pattern, HttpMethod httpMethod) {
        methodPathMatcher.excludePathPatterns(pattern, httpMethod);
        return this;
    }
}
