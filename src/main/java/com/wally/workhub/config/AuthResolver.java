package com.wally.workhub.config;

import com.wally.workhub.config.data.UserSession;
import com.wally.workhub.exception.Unauthorized;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class AuthResolver implements HandlerMethodArgumentResolver{
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // request 받는 파라미터에 UserSession이 있는지 확인
        return parameter.getParameterType().equals(UserSession.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);

        if(servletRequest == null){
            throw new Unauthorized();
        }

        Cookie[] cookies = servletRequest.getCookies();
        if(cookies.length == 0){
            throw new Unauthorized();
        }

        String accessToken = webRequest.getHeader("Authorization");
        if(accessToken == null && accessToken.equals("")){
            throw new Unauthorized();
        }

        // 예제니까 넣는거지 큰 의미 없음

        return new UserSession(1L);
    }
}
