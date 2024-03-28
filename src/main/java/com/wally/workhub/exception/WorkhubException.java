package com.wally.workhub.exception;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

// 최상위 예외 클래스로 ExceptionHandler에서 처리할 예외를 상속받는다.
@Getter
public abstract class WorkhubException extends RuntimeException {

    private final Map<String, String> validation = new HashMap<>();

    public WorkhubException(String message) {
        super(message);
    }

    public WorkhubException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract int getStatusCode();

    public void addValidation(String fieldName, String message) {
        validation.put(fieldName, message);
    }

}
