package com.wally.workhub.domain.task.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum TaskProgressStage {
    CREATED("CREATED", "생성됨"),
    IN_PROGRESS("IN_PROGRESS", "진행중"),
    COMPLETED("COMPLETED", "완료됨"),
    CANCELLED("CANCELLED", "취소됨")
    ;

    private final String code;
    private final String name;

}
