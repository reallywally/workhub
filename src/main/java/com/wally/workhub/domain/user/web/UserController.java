package com.wally.workhub.domain.user.web;

import com.wally.workhub.config.UserPrincipal;
import com.wally.workhub.domain.user.model.AppUser;
import com.wally.workhub.domain.user.model.UserResponse;
import com.wally.workhub.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody AppUser appUser) {
        try {

            return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/users/me")
    public ResponseEntity<UserResponse> getMe(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        if (userPrincipal == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        UserResponse userResponse = userService.getUserProfile(userPrincipal.getUserId());
        return ResponseEntity.ok().body(userResponse);
    }
}
