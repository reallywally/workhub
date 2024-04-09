package com.wally.workhub.domain.auth.service;

import com.wally.workhub.crypto.PasswordEncoder;
import com.wally.workhub.domain.auth.model.Signup;
import com.wally.workhub.domain.user.model.User;
import com.wally.workhub.domain.user.service.UserRepository;
import com.wally.workhub.exception.InvalidRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public void signUp(Signup signup) {
        User findUser = userRepository.findByEmail(signup.getEmail());

        if (findUser != null) {
            throw new InvalidRequest("email", "Email already exists");
        }

        PasswordEncoder passwordEncoder = new PasswordEncoder();
        String encryptedPassword = passwordEncoder.encrypt(signup.getPassword());

        User user = User.builder()
                .username(signup.getName())
                .password(encryptedPassword)
                .email(signup.getEmail())
                .build();

        userRepository.save(user);
    }

}
