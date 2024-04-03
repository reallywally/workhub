package com.wally.workhub.domain.auth.web;

import com.wally.workhub.domain.auth.model.Login;
import com.wally.workhub.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/login")
    public ResponseEntity<Object> login(@RequestBody Login login) {
        log.info("login: {}", login);
        String accessToken = authService.signIn(login);

        ResponseCookie cookie = ResponseCookie.from("SESSION", accessToken)
                .domain("localhost")  // 서버 환경에 따른 분리 필요
                .path("/")
                .httpOnly(true)
                .maxAge(Duration.ofDays(30)) // 쿠키는 보돈 30일
                .build();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .build();
    }
}
