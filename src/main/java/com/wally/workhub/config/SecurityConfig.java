package com.wally.workhub.config;

import com.wally.workhub.config.handler.Http401Handler;
import com.wally.workhub.config.handler.Http403Handler;
import com.wally.workhub.config.handler.LoginFailHandler;
import com.wally.workhub.config.handler.LoginSuccessHandler;
import com.wally.workhub.domain.user.model.AppUser;
import com.wally.workhub.domain.user.service.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {

    // 시큐리티 인증 무시
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers("/favicon.ico")
                .requestMatchers("/error");
    }

    // 기본 시큐리티 필터 체인
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorizeRequests) ->
                        authorizeRequests
                                .requestMatchers("/auth/**").permitAll()
//                                .requestMatchers("/user").hasAnyRole("ADMIN", "USER")
//                                .requestMatchers("/admin").hasRole("ADMIN")
                                // .requestMatchers("/admin").access(new WebExpressionAuthorizationManager("hasRole('ADMIN')")) 이건 참
                                .anyRequest().authenticated()
                )
                .formLogin((formLogin) ->
                        formLogin
                                .loginPage("/auth/login")
                                .loginProcessingUrl("/auth/login")
                                .usernameParameter("username")
                                .passwordParameter("password")
                                .defaultSuccessUrl("/")
                                .failureHandler(new LoginFailHandler())
                                .successHandler(new LoginSuccessHandler())
                )
                .rememberMe((rememberMe) ->
                        rememberMe
                                .rememberMeParameter("rememberMe")
                                .rememberMeCookieName("remember-me")
                                .alwaysRemember(false)
                                .tokenValiditySeconds(60 * 60 * 24 * 14)
                )
                .exceptionHandling((exceptionHandling) ->
                        exceptionHandling
                                .accessDeniedHandler(new Http403Handler())
                                .authenticationEntryPoint(new Http401Handler())
                )
                .build();
    }

    // 빈으로 등록되서 filter chain에 등록안해도 자동으로 들어감
    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> {
            AppUser appUser = userRepository.findByEmail(username);
            return new UserPrincipal(appUser);
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
