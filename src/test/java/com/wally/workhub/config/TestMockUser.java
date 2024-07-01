package com.wally.workhub.config;

import org.springframework.security.test.context.support.WithSecurityContext;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = TestMockSecurityContext.class)
public @interface TestMockUser {

    String email() default "wall2@naver.com";

    String password() default "1111";

//    String role() default "ROLE_ADMIN";
}
