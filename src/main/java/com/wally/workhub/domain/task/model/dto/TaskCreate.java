package com.wally.workhub.domain.task.model.dto;


import com.wally.workhub.domain.task.model.Task;
import com.wally.workhub.domain.task.model.enums.TaskProgressStage;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class TaskCreate {
    private Long advertiserId;
    private Long projectId;
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
}
