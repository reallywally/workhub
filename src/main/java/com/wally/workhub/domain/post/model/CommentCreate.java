package com.wally.workhub.domain.post.model;

import com.wally.workhub.exception.InvalidRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
public class CommentCreate {

    @NotBlank(message = "작성자를 입력해주세요")
    private String author;

    @Length(max = 1000, message = "내용은 1000자 이내로 작성해 주세요.")
    @NotBlank(message = "내용을 입력해 주세요.")
    private String content;

    @NotBlank(message = "비밀번호를 입력해 주세요.")
    private String password;

    @Builder
    public CommentCreate(String author, String content, String password) {
        this.author = author;
        this.content = content;
        this.password = password;
    }
}
