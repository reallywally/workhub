package com.wally.workhub.config;

import com.wally.workhub.config.filter.EmailPasswordAuthFilter;
import com.wally.workhub.config.handler.Http401Handler;
import com.wally.workhub.config.handler.Http403Handler;
import com.wally.workhub.config.handler.LoginFailHandler;
import com.wally.workhub.config.handler.LoginSuccessHandler;
import com.wally.workhub.domain.user.model.AppUser;
import com.wally.workhub.domain.user.service.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserRepository userRepository;

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
                                        .requestMatchers("/api/login").permitAll()
                                        // .requestMatchers("/auth/**").permitAll()
//                                .requestMatchers("/user").hasAnyRole("ADMIN", "USER")
//                                .requestMatchers("/admin").hasRole("ADMIN")
                                        // .requestMatchers("/admin").access(new WebExpressionAuthorizationManager("hasRole('ADMIN')")) 이건 참
                                        .anyRequest().authenticated()
                )
                // 폼 로그인은 안써서 주척 처리
//                .formLogin((formLogin) ->
//                        formLogin
//                                .loginPage("/auth/login")
//                                .loginProcessingUrl("/auth/login")
//                                .usernameParameter("email")
//                                .passwordParameter("password")
//                                .defaultSuccessUrl("/")
//                                .failureHandler(new LoginFailHandler())
//                                .successHandler(new LoginSuccessHandler())
//                )
                // custom login filter
                .addFilterBefore(emailPasswordAuthFilter(), UsernamePasswordAuthenticationFilter.class)
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

    @Bean
    public EmailPasswordAuthFilter emailPasswordAuthFilter() throws Exception {
        EmailPasswordAuthFilter filter = new EmailPasswordAuthFilter("/auth/login");
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationSuccessHandler(new LoginSuccessHandler());
        filter.setAuthenticationFailureHandler(new LoginFailHandler());
        filter.setSecurityContextRepository(new HttpSessionSecurityContextRepository());

        return filter;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService(userRepository));
        provider.setPasswordEncoder(passwordEncoder());

        return new ProviderManager(provider);
    }

    // 빈으로 등록되서 filter chain에 등록안해도 자동으로 들어감
    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return email -> {
            AppUser appUser = userRepository.findByEmail(email);
            return new UserPrincipal(appUser);
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
