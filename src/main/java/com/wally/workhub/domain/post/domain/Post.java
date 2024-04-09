package com.wally.workhub.domain.post.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    private String content;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Comment> comments;

    @Builder
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public PostEditor.PostEditorBuilder toEditor(){
        return PostEditor.builder()
                .title(this.title)
                .content(this.content);
    }

    public void edit(PostEditor postEditor){
        this.title = postEditor.getTitle();
        this.content = postEditor.getContent();
    }

    public void addComment(Comment comment){
        this.comments.add(comment);
    }
}
