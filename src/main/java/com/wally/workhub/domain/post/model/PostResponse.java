package com.wally.workhub.domain.post.model;

import com.wally.workhub.domain.post.domain.Post;
import lombok.Builder;
import lombok.Data;

@Data
public class PostResponse {
    private Long id;
    private String title;
    private String content;

    // 생성자 오버로당
    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
    }

    @Builder
    public PostResponse(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
