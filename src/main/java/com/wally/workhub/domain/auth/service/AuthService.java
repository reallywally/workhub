package com.wally.workhub.domain.auth.service;

import com.wally.workhub.domain.auth.model.Login;
import com.wally.workhub.domain.auth.model.Session;
import com.wally.workhub.domain.user.model.User;
import com.wally.workhub.domain.user.service.UserRepository;
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

        Session session = user.addSession();

        return user.getId();


    }
}
