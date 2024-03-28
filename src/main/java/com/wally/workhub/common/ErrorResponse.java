package com.wally.workhub.common;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
public class ErrorResponse {
    private String message;
    private String code;
    private String status;
    private Map<String, String> validation;

    @Builder
    public ErrorResponse(String message, String code, String status, Map<String, String> validation) {
        this.message = message;
        this.code = code;
        this.status = status;
        this.validation = validation;
    }

    public void addValidationError(String field, String message) {
        validation.put(field, message);
    }

}
