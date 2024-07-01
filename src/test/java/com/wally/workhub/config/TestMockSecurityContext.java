package com.wally.workhub.config;

import com.wally.workhub.domain.user.model.AppUser;
import com.wally.workhub.domain.user.service.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

import java.util.List;

@RequiredArgsConstructor
public class TestMockSecurityContext implements WithSecurityContextFactory<TestMockUser> {

    @Override
    public SecurityContext createSecurityContext(TestMockUser annotation) {
        var user = AppUser.builder()
                .email(annotation.email())
                .password(annotation.password())
                .build();

        var principal = new UserPrincipal(user);

        var role = new SimpleGrantedAuthority("ROLE_ADMIN");
        var authenticationToken = new UsernamePasswordAuthenticationToken(principal,
                user.getPassword(),
                List.of(role));

        var context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authenticationToken);

        return context;
    }
}
