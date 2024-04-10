package com.wally.workhub.domain.user.service;


import com.wally.workhub.domain.user.model.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public AppUser registerUser(AppUser appUser) {
        if (userRepository.findByUsername(appUser.getUsername()) != null) {
            throw new RuntimeException("Username already exists");
        }

        if (userRepository.findByEmail(appUser.getEmail()) != null) {
            throw new RuntimeException("Email already exists");
        }


        return userRepository.save(appUser);
    }
}
