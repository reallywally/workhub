package com.wally.workhub.domain.user.service;


import com.wally.workhub.config.UserPrincipal;
import com.wally.workhub.domain.user.model.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByEmail(username);
        return new UserPrincipal(appUser);
    }

}
