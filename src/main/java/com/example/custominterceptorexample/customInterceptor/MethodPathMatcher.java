package com.example.custominterceptorexample.customInterceptor;
import lombok.AllArgsConstructor;
import org.springframework.util.AntPathMatcher;

import java.util.ArrayList;
import java.util.List;

public class MethodPathMatcher {

    @AllArgsConstructor
    static private class PatternAndMethod {
        public String pattern;
        public HttpMethod httpMethod;
    }

    private List<PatternAndMethod> includePatterns = new ArrayList<>();
    private List<PatternAndMethod> excludePatterns = new ArrayList<>();
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    public void addPathPatterns(String pattern, HttpMethod httpMethod) {
        includePatterns.add(new PatternAndMethod(pattern, httpMethod));
    }

    public void excludePathPatterns(String pattern, HttpMethod httpMethod) {
        excludePatterns.add(new PatternAndMethod(pattern, httpMethod));
    }

    public boolean match(String URI, String method) {
        HttpMethod httpMethod = HttpMethod.getHttpMethod(method);

        boolean includeFlag = includePatterns.stream().anyMatch(patternAndMethod ->
                antPathMatcher.match(patternAndMethod.pattern, URI)
                        && ((patternAndMethod.httpMethod == HttpMethod.ALL) || httpMethod == patternAndMethod.httpMethod));

        boolean excludeFlag = excludePatterns.stream().anyMatch(patternAndMethod ->
                antPathMatcher.match(patternAndMethod.pattern, URI)
                        && ((patternAndMethod.httpMethod == HttpMethod.ALL) || httpMethod == patternAndMethod.httpMethod));

        return includeFlag && !excludeFlag;
    }
}
