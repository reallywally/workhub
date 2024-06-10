package com.wally.workhub.config;

import com.wally.workhub.domain.user.model.AppUser;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Getter
public class UserPrincipal extends User {

    private final Long userId;
    private final String name;
    private final int age;

    public UserPrincipal(AppUser appUser) {
        super(appUser.getEmail(), appUser.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_ADMIN")));
        this.userId = appUser.getId();
        this.name = appUser.getUsername();
        this.age = appUser.getAge();
    }
}
