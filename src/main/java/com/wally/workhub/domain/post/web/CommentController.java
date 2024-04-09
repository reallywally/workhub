package com.wally.workhub.domain.post.web;

import com.wally.workhub.domain.post.model.CommentCreate;
import com.wally.workhub.domain.post.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/posts/{postId}/comments")
    public void write(@PathVariable Long postId, @RequestBody @Valid CommentCreate commentCreate) {
        commentService.write(postId);
    }

    @DeleteMapping("comments/{commentId}")
    public void delete(@PathVariable Long commentId) {
        commentService.delete(commentId);
    }
}
