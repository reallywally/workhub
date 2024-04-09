package com.wally.workhub.domain.post.service;

import com.wally.workhub.domain.post.domain.Comment;
import com.wally.workhub.domain.post.domain.Post;
import com.wally.workhub.domain.post.repository.CommentRepository;
import com.wally.workhub.domain.post.repository.PostRepository;
import com.wally.workhub.exception.PostNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public void write(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(PostNotFound::new);

        Comment comment = Comment.builder()
                .author("author")
                .content("content")
                .password("password")
                .build();
        comment.setPost(post);

        post.addComment(comment);
    }

    public void delete(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));

        commentRepository.delete(comment);
    }
}
