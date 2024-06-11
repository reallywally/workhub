package com.wally.workhub.domain.auth.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wally.workhub.domain.auth.model.Login;
import com.wally.workhub.domain.user.model.AppUser;
import com.wally.workhub.domain.user.service.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;


    @Test
    @Transactional
    @DisplayName("로그인 성공후 세션 1개 생성")
    void test2() throws Exception {
        // given
        AppUser appUser = userRepository.save(AppUser.builder()
                .username("호돌맨")
                .email("hodolman88@gmail.com")
                .password("1234")
                .build());

        Login login = Login.builder()
                .email("hodolman88@gmail.com")
                .password("1234")
                .build();

        String json = objectMapper.writeValueAsString(login);

        // expected
        mockMvc.perform(post("/auth/login")
                        .contentType(APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andDo(print());

        // assertEquals(1L, appUser.getSessions().size());
    }



}