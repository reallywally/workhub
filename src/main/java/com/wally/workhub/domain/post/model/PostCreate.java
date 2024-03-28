package com.wally.workhub.domain.post.model;

import com.wally.workhub.exception.InvalidRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
public class PostCreate {

    @NotBlank(message = "제목을 입력해 주세요.")
    private String title;

    @NotBlank(message = "내용을 입력해 주세요.")
    private String content;

    @Builder
    public PostCreate(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void validate(){
        if(title.contains("바보")){
            throw new InvalidRequest("title", "바보는 금지된 단어입니다.");
        }
    }
}
