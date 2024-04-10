package com.example.custominterceptorexample.customInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@RequiredArgsConstructor
public class OuterInterceptor implements HandlerInterceptor {

    private final CustomInterceptor interceptor;
    private final MethodPathMatcher pathMatcher;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(CheckAnnotation(handler) || pathMatcher.match(request.getRequestURI(), request.getMethod())) {
            return interceptor.preHandle(request, response, handler);
        }
        else return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(CheckAnnotation(handler) || pathMatcher.match(request.getRequestURI(), request.getMethod())) {
            interceptor.postHandle(request, response, handler, modelAndView);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if(CheckAnnotation(handler) || pathMatcher.match(request.getRequestURI(), request.getMethod())) {
            interceptor.afterCompletion(request, response, handler, ex);
        }
    }

    private boolean CheckAnnotation(Object handler) {
        if(!(handler instanceof HandlerMethod)) return false;
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        InterceptorMapping annotation = handlerMethod.getMethodAnnotation(InterceptorMapping.class);
        if(annotation != null && Arrays.stream(annotation.value()).anyMatch(target -> target == interceptor.getClass())) return true;
        else return false;
    }
}
