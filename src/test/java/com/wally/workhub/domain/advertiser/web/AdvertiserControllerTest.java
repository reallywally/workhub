package com.wally.workhub.domain.advertiser.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wally.workhub.config.TestMockUser;
import com.wally.workhub.domain.advertiser.AdvertiserTestUtils;
import com.wally.workhub.domain.advertiser.model.AdvertiserCreate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AdvertiserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("광고주 등록 테스트")
    void testCreatAdvertiser() throws Exception {
        // given
        AdvertiserCreate advertiserCreate = AdvertiserTestUtils.generateAdvertiserCreate();

        String json = objectMapper.writeValueAsString(advertiserCreate);

        mockMvc.perform(post("/advertisers")
                        .contentType(APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("광고주 조회 테스트")
    void testGetAdvertiser() throws Exception {
        // given
        mockMvc.perform(get("/advertisers")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("광고주 수정 테스트")
    void testPatchAdvertiser() throws Exception {
        // given
        // 이건 실패가 맞는데,,
        mockMvc.perform(patch("/advertisers")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("광고주 삭제 테스트")
    void testDeleteAdvertiser() throws Exception {
        // given
        mockMvc.perform(delete("/advertisers")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}