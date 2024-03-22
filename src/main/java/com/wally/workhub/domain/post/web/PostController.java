package com.wally.workhub.domain.post.web;

import com.wally.workhub.domain.post.domain.Post;
import com.wally.workhub.domain.post.model.PostCreate;
import com.wally.workhub.domain.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts/{postId}")
    public Post get(@PathVariable Long postId) {

        Post post = postService.get(postId);
        return post;
    }

    @PostMapping("/posts")
    public String getPost(@RequestBody @Valid PostCreate postCreate) {
        postService.write(postCreate);

        return "Post";
    }
}
