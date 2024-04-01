package com.wally.workhub.domain.auth.web;

import com.wally.workhub.domain.auth.model.Login;
import com.wally.workhub.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/login")
    public void login(@RequestBody Login login) {
        log.info("login: {}", login);
        String accessToken = authService.signIn(login);

        log.info("accessToken: {}", accessToken);
    }
}
