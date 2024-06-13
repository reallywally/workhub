package com.wally.workhub.domain.task.model.dto;

import com.wally.workhub.domain.task.model.enums.TaskManagerCharge;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskManagerCreate {
    private TaskManagerCharge chargeType;
    private Long userId;
}
