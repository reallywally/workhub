package com.wally.workhub.domain.task.model;


import com.wally.workhub.domain.task.domain.Task;
import com.wally.workhub.enums.TaskProgressStage;
import com.wally.workhub.exception.InvalidRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class TaskCreate {
    @NotBlank(message = "광고주는 필수 입력입니다.")
    private Long advertiserId;
    @NotBlank(message = "프로젝트는 필수 입력입니다.")
    private Long projectId;
    @NotBlank(message = "플랫폼은 필수 입력입니다.")
    private String platform;
    private String platformProduct;
    private String requestName;
    private String content;
    private TaskProgressStage progressStage;
    private LocalDateTime deadline;
    private List<TaskManagerCreate> managers;

    public Task toEntity(){
        return Task.builder()
                .advertiserId(advertiserId)
                .projectId(projectId)
                .platform(platform)
                .platformProduct(platformProduct)
                .requestName(requestName)
                .content(content)
                .progressStage(progressStage)
                .deadline(deadline)
                .status("ACTIVE")
                .build();
    }

    public void validate(){
        if(content.contains("바보")){
            throw new InvalidRequest("content", "바보는 금지된 단어입니다.");
        }
    }
}
