package com.wally.workhub.domain.post.service;

import com.wally.workhub.domain.extension.TimeExtension;
import com.wally.workhub.domain.post.domain.Post;
import com.wally.workhub.domain.post.model.PostCreate;
import com.wally.workhub.domain.post.model.PostResponse;
import com.wally.workhub.domain.post.repository.PostRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.mockito.BDDMockito.given;


@SpringBootTest
class PostServiceSpringTest {

    @Autowired
    private PostService postService;


    @Test
    @DisplayName("게시글 작성 테스트")
    @Transactional
    void test1(){
        // given
        PostCreate postCreate = PostCreate.builder()
                .title("제목44")
                .content("내용44")
                .build();

        // when
        postService.write(postCreate);

        // then
    }

    @Test
    @DisplayName("글 1개 조회")
    void test2(){
        // given
        Long postId = 15L;
        Post post = Post.builder().title("제목1").content("내용1").build();
        // given(postRepository.findById(postId)).willReturn(Optional.ofNullable(post));

        // when
        PostResponse postResponse = postService.get(postId);

        // then
        Assertions.assertNotNull(postResponse);
    }
}

