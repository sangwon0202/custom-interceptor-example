package com.example.custominterceptorexample.customInterceptor;
public enum HttpMethod {
    GET, POST, DELETE, PUT, ALL;

    public static HttpMethod getHttpMethod(String method) {
        if(method.equals("GET")) return GET;
        if(method.equals("POST")) return POST;
        if(method.equals("DELETE")) return DELETE;
        if(method.equals("PUT")) return PUT;
        return ALL;
    }

}
