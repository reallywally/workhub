package com.wally.workhub.domain.post.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PostEditor {
    private String title;
    private String content;

    @Builder
    public PostEditor(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
