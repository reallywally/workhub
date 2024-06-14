package com.wally.workhub.domain.task;

import com.wally.workhub.domain.task.domain.Task;
import com.wally.workhub.domain.task.model.TaskCreate;
import com.wally.workhub.domain.task.model.TaskManagerCreate;
import com.wally.workhub.enums.TaskManagerCharge;
import com.wally.workhub.enums.TaskProgressStage;

import java.time.LocalDateTime;
import java.util.List;

public class TaskTestUtils {
    public static Task generateTask() {
        return Task.builder()
                .build();
    }

    public static TaskCreate generateTaskCreate() {
        return TaskCreate.builder()
                .advertiserId(1L)
                .projectId(1L)
                .platform("KAKAO")
                .platformProduct("DISPLAY")
                .requestName("24년 6월 카카오 광고 설정")
                .content("이거랑 저거랑 요거랑 다 셋팅해 주세요")
                .progressStage(TaskProgressStage.CREATED)
                .deadline(LocalDateTime.now())
                .managers(TaskTestUtils.generateTaskManagerCreateList())
                .build();
    }

    public static List<TaskManagerCreate> generateTaskManagerCreateList() {
        return List.of(
                TaskManagerCreate.builder()
                        .chargeType(TaskManagerCharge.REQUESTER)
                        .userId(1L)
                        .build(),
                TaskManagerCreate.builder()
                        .chargeType(TaskManagerCharge.MANAGER)
                        .userId(2L)
                        .build());
    }
}
