package com.wally.workhub.domain.post.repository;

import com.wally.workhub.domain.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
