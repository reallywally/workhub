package com.wally.workhub.domain.post.service;

import com.wally.workhub.domain.extension.TimeExtension;
import com.wally.workhub.domain.post.domain.Post;
import com.wally.workhub.domain.post.model.PostCreate;
import com.wally.workhub.domain.post.model.PostResponse;
import com.wally.workhub.domain.post.repository.PostRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.BDDMockito.given;


@ExtendWith({MockitoExtension.class, TimeExtension.class})
class PostServiceTest {
    @Mock
    private PostRepository postRepository;
    @InjectMocks
    private PostService postService;


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
    }

    @Test
    @DisplayName("글 1개 조회")
    void test2(){
        // given
        Long postId = 6L;
        Post post = Post.builder().title("제목1").content("내용1").build();
        given(postRepository.findById(postId)).willReturn(Optional.ofNullable(post));

        // when
        PostResponse postResponse = postService.get(postId);

        // then
        Assertions.assertNotNull(postResponse);
    }
}

