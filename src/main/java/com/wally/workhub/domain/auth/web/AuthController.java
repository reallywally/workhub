package com.wally.workhub.domain.auth.web;

import com.wally.workhub.config.AppConfig;
import com.wally.workhub.domain.auth.model.Login;
import com.wally.workhub.domain.auth.model.Signup;
import com.wally.workhub.domain.auth.service.AuthService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.time.Duration;
import java.util.Base64;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    private final AppConfig appConfig;

    @PostMapping("/auth/login")
    public String login(@RequestBody Login login) {
        Long userId = authService.signIn(login);
        // 키 생성
//        SecretKey key = Jwts.SIG.HS256.key().build();
//        byte[] encoded = key.getEncoded();
//        String strKey = Base64.getEncoder().encodeToString(encoded);
        SecretKey secretKey = Keys.hmacShaKeyFor(appConfig.getJwtKey());

        String jws = Jwts.builder()
                .subject(String.valueOf(userId))
                .signWith(secretKey)
                .compact();

        return jws;
    }

    @PostMapping("/auth/signup")
    public void signup(@RequestBody Signup signup) {
        authService.signUp(signup);
    }
}
