package com.wally.workhub.config;


import com.wally.workhub.exception.Unauthorized;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// 크게 implements 하거나 extends 하는데 우선 샘플은 implements로 함
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info(">> preHandle");

        String accessToken = request.getParameter("accessToken");
        if (accessToken != null && accessToken.equals("1234")) {
            return true;
        }

        throw new Unauthorized();
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info(">> postHandle");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info(">> afterCompletion");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
