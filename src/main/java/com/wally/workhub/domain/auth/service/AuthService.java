package com.wally.workhub.domain.auth.service;

import com.wally.workhub.domain.auth.model.Signup;
import com.wally.workhub.domain.user.model.AppUser;
import com.wally.workhub.domain.user.service.UserRepository;
import com.wally.workhub.exception.InvalidRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(Signup signup) {
        AppUser findAppUser = userRepository.findByEmail(signup.getEmail());

        if (findAppUser != null) {
            throw new InvalidRequest("email", "Email already exists");
        }

        String encryptedPassword = passwordEncoder.encode(signup.getPassword());

        AppUser appUser = AppUser.builder()
                .username(signup.getName())
                .password(encryptedPassword)
                .email(signup.getEmail())
                .build();

        userRepository.save(appUser);
    }

}
