package com.wally.workhub.config;

import com.wally.workhub.domain.user.model.AppUser;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public class UserPrincipal extends User {

    private final Long userId;

    public UserPrincipal(AppUser appUser) {
        super(appUser.getEmail(), appUser.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_ADMIN")));
        this.userId = appUser.getId();
    }
}
