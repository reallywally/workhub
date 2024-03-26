package com.wally.workhub.domain.post.service;

import com.wally.workhub.domain.post.domain.Post;
import com.wally.workhub.domain.post.model.PostCreate;
import com.wally.workhub.domain.post.model.PostResponse;
import com.wally.workhub.domain.post.repository.PostRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

//    @BeforeEach
//    void clean() {
//        postRepository.deleteAll();
//    }

    @Test
    @DisplayName("게시글 작성 테스트")
    void test1(){
        // given
        PostCreate postCreate = PostCreate.builder()
                .title("제목")
                .content("내용")
                .build();

        // when
        postService.write(postCreate);

        // then
        Assertions.assertEquals(2L, postRepository.count());
    }

    @Test
    @DisplayName("글 1개 조회")
    void test2(){
        // given
//        PostCreate postCreate = PostCreate.builder()
//                .title("제목")
//                .content("내용")
//                .build();
//
//        postService.write(postCreate);
        Long postId = 5L;

        // when
        PostResponse postResponse = postService.get(postId);

        // then
        Assertions.assertNotNull(postResponse);
    }
}