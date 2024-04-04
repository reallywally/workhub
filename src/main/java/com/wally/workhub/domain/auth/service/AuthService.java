package com.wally.workhub.domain.auth.service;

import com.wally.workhub.crypto.PasswordEncoder;
import com.wally.workhub.domain.auth.model.Login;
import com.wally.workhub.domain.auth.model.Signup;
import com.wally.workhub.domain.user.model.User;
import com.wally.workhub.domain.user.service.UserRepository;
import com.wally.workhub.exception.InvalidRequest;
import com.wally.workhub.exception.InvalidSignInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public Long signIn(Login login) {
        User user = userRepository.findByEmail(login.getEmail());

        if (user == null) {
            throw new InvalidSignInformation();
        }

        SCryptPasswordEncoder passwordEncoder = new SCryptPasswordEncoder(16, 8, 1, 32, 64);
        boolean matches = passwordEncoder.matches(login.getPassword(), user.getPassword());

        if (!matches) {
            throw new InvalidSignInformation();
        }

        return user.getId();
    }

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
