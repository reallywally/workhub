package com.wally.workhub.domain.task.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum TaskManagerCharge {
    REQUESTER("REQUESTER", "요청자"),
    MANAGER("MANAGER", "담당자");

    private final String code;
    private final String name;

}
