package com.wally.workhub.domain.post.web;

import com.wally.workhub.config.data.UserSession;
import com.wally.workhub.domain.post.model.PostCreate;
import com.wally.workhub.domain.post.model.PostEdit;
import com.wally.workhub.domain.post.model.PostResponse;
import com.wally.workhub.domain.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/foo")
    public String foo(UserSession userSession) {
        log.info("userName: {}", userSession.userName);

        return "foo";
    }

    @GetMapping("/posts/{postId}")
    public PostResponse get(@PathVariable Long postId) {
        PostResponse postResponse = postService.get(postId);
        return postResponse;
    }

    @GetMapping("/posts")
    public List<PostResponse> getList(Pageable pageable) {
        return postService.getList(pageable);
    }

    @PostMapping("/posts")
    public String getPost(@RequestBody @Valid PostCreate postCreate) {
        postCreate.validate();
        postService.write(postCreate);

        return "Post";
    }

    @PatchMapping("/posts/{postId}")
    public void editPost(@PathVariable Long postId, @RequestBody @Valid PostEdit postEdit) {
        postService.edit(postId, postEdit);
    }

    @DeleteMapping("/posts/{postId}")
    public void deletePost(@PathVariable Long postId) {
        postService.delete(postId);
    }
}
