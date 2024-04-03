package com.wally.workhub.domain.auth.service;

import com.wally.workhub.domain.auth.model.Login;
import com.wally.workhub.domain.auth.model.Signup;
import com.wally.workhub.domain.user.model.User;
import com.wally.workhub.domain.user.service.UserRepository;
import com.wally.workhub.exception.InvalidRequest;
import com.wally.workhub.exception.InvalidSignInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public Long signIn(Login login) {
        User user = userRepository.findByEmailAndPassword(login.getEmail(), login.getPassword())
                .orElseThrow(InvalidSignInformation::new);

        return user.getId();
    }

    public void signUp(Signup signup) {

        User findUser = userRepository.findByEmail(signup.getEmail());

        if(findUser != null) {
            throw new InvalidRequest("email", "Email already exists");
        }

        User user = User.builder()
                .username(signup.getName())
                .password(signup.getPassword())
                .email(signup.getEmail())
                .build();

        userRepository.save(user);
    }

}
