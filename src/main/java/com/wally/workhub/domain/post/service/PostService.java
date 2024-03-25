package com.wally.workhub.domain.post.service;

import com.wally.workhub.domain.post.domain.Post;
import com.wally.workhub.domain.post.model.PostCreate;
import com.wally.workhub.domain.post.model.PostResponse;
import com.wally.workhub.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostResponse get(Long id){
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

        PostResponse postResponse = PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();

        return postResponse;
    }

    public void write(PostCreate postCreate) {
        Post post = Post.builder()
                .title(postCreate.getTitle())
                .content(postCreate.getContent())
                .build();

        postRepository.save(post);

    }

    public List<PostResponse> getList(Pageable pageable) {
        // Pageable pageable = PageRequest.of(page, 5);

        return postRepository.findAll(pageable).stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }
}
