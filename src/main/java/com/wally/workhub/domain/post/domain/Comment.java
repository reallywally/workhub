package com.wally.workhub.domain.post.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.lang.annotation.Target;

@Entity
@Table
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String author;

    @Column
    private String content;

    @Column
    private String password;

    @ManyToOne
    @JoinColumn
    private Post post;

    @Builder
    public Comment(String author, String content, String password) {
        this.author = author;
        this.content = content;
        this.password = password;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
