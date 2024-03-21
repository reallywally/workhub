package com.wally.workhub.domain.post.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @GetMapping("/posts")
    public String getPosts() {
        return "Posts";
    }
}
