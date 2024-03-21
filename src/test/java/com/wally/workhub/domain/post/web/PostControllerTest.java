package com.wally.workhub.domain.post.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wally.workhub.domain.post.model.PostCreate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest
class PostControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test() throws Exception {
        // given
        mockMvc.perform(get("/posts")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().string("Posts"));

        // when

        // then
    }

    @Test
    void postTest() throws Exception {
        // given
        PostCreate request = PostCreate.builder()
                .title("")
                .content("내용입니다.")
                .build();

        String json = objectMapper.writeValueAsString(request);
        mockMvc.perform(get("/post2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest())
                .andDo(print());
        // when

        // then
    }
}