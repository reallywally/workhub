package com.wally.workhub.domain.post.repository;

import com.wally.workhub.domain.post.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
