package com.wally.workhub.domain.advertiser.web;

import com.wally.workhub.config.TestMockUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AdvertiserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @TestMockUser
    @DisplayName("광고주 목록 조회")
    void test1() throws Exception {
        // given

        // when

        // then
        mockMvc.perform(get("/advertisers?page=1&size=10")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}