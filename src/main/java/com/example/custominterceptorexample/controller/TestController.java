package com.example.custominterceptorexample.controller;

import com.example.custominterceptorexample.customInterceptor.InterceptorMapping;
import com.example.custominterceptorexample.interceptor.Annotation1Interceptor;
import com.example.custominterceptorexample.interceptor.Annotation2Interceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/path1")
    public String getPath1() {
        return "path1";
    }

    @PostMapping("/path1")
    @InterceptorMapping(Annotation1Interceptor.class)
    public String PostPath1() {
        return "path1";
    }

    @GetMapping("/path2")
    @InterceptorMapping(Annotation2Interceptor.class)
    public String getPath2() {
        return "path2";
    }

    @PostMapping("/path2")
    @InterceptorMapping({Annotation1Interceptor.class, Annotation2Interceptor.class})
    public String PostPath2() {
        return "path2";
    }

}
