package com.wally.workhub.exception;


import lombok.Getter;

@Getter
public class InvalidRequest extends WorkhubException {
    private static final String MESSAGE = "잘못된 요청입니다.";


    public InvalidRequest(String fieldName, String message) {
        super(MESSAGE);
        addValidation(fieldName, message);
    }

    @Override
    public int getStatusCode() {
        return 400;
    }
}
