package com.wally.workhub.config;

import com.wally.workhub.config.data.UserSession;
import com.wally.workhub.exception.Unauthorized;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.crypto.SecretKey;
import java.util.Base64;

@Slf4j
@RequiredArgsConstructor
public class AuthResolver implements HandlerMethodArgumentResolver{
    private final AppConfig appConfig;;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // request 받는 파라미터에 UserSession이 있는지 확인
        return parameter.getParameterType().equals(UserSession.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String jws = webRequest.getHeader("Authorization");
        if(jws == null && jws.equals("")){
            throw new Unauthorized();
        }

        SecretKey secretKey = Keys.hmacShaKeyFor(appConfig.getJwtKey());

        try {

            Jws<Claims> claimsJws = Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(jws);

            String userId = claimsJws.getPayload().getSubject();
            //OK, we can trust this JWT
            return new UserSession(Long.valueOf(userId));

        } catch (JwtException e) {

            //don't trust the JWT!
            throw new Unauthorized();
        }
    }
}
