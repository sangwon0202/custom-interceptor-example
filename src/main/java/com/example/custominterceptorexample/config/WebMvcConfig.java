package com.example.custominterceptorexample.config;

import com.example.custominterceptorexample.customInterceptor.CustomInterceptorRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final CustomInterceptorRegistry customInterceptorRegistry;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        customInterceptorRegistry.addInterceptorsAuto(registry);
    }

}
