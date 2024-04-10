package com.example.custominterceptorexample.customInterceptor;

import org.springframework.web.servlet.config.annotation.InterceptorRegistration;

public class OrderSetter {

    private Integer order = null;
    public void setOrder(int order) {
        this.order = order;
    }

    public void setRegistrationOrder(InterceptorRegistration interceptorRegistration) {
        if(order != null) interceptorRegistration.order(order);
    }
}
