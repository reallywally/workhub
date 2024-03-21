package com.wally.workhub.domain.post.web;

import com.wally.workhub.domain.post.model.PostCreate;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PostController {

    @GetMapping("/posts")
    public String getPosts() {
        return "Posts";
    }

    @PostMapping("/post2")
    public String getPost(@RequestBody @Valid PostCreate postCreate) {

        log.info("params: {}", postCreate.toString());

        return "Post";
    }
}
