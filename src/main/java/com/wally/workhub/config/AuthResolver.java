package com.wally.workhub.config;

import com.wally.workhub.config.data.UserSession;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class AuthResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // AuthResolver를 사용하는게 맞는지 체크.
        // workhub는 UserSession이 있으면 인증이 필요하다고 체크
        return parameter.getParameter().equals(UserSession.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String accessToken = webRequest.getHeader("Authorization");
        if(accessToken == null || accessToken.isEmpty()) {
            throw new RuntimeException("인증이 필요합니다.");
        }

        return new UserSession(1L);
    }
}
