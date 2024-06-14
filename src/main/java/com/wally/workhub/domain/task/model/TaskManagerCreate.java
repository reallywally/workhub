package com.wally.workhub.domain.task.model;

import com.wally.workhub.enums.TaskManagerCharge;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskManagerCreate {
    private TaskManagerCharge chargeType;
    private Long userId;
}
