package com.wally.workhub.config.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wally.workhub.common.ErrorResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
public class LoginFailHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.error("로그인실패");

        ErrorResponse errorResponse = ErrorResponse.builder()
                .status("400")
                .message("로그인실패")
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String errorResponseJson = objectMapper.writeValueAsString(errorResponse);

        response.getWriter().write(errorResponseJson);
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    }
}
