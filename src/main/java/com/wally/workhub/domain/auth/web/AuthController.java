package com.wally.workhub.domain.auth.web;

import com.wally.workhub.config.AppConfig;
import com.wally.workhub.config.data.UserSession;
import com.wally.workhub.domain.auth.model.Signup;
import com.wally.workhub.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    private final AppConfig appConfig;

    @GetMapping("/test")
    public String test(UserSession userSession) {
        return "test";
    }

    @PostMapping("/auth/signup")
    public void signup(@RequestBody Signup signup) {
        authService.signUp(signup);
    }
}
