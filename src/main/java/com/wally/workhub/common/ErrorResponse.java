package com.wally.workhub.common;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ErrorResponse {
    private String message;
    private String code;
    private String status;
    private Map<String, String> validationErrors = new HashMap<>();

    @Builder
    public ErrorResponse(String message, String code, String status) {
        this.message = message;
        this.code = code;
        this.status = status;
    }

    public void addValidationError(String field, String message) {
        validationErrors.put(field, message);
    }

}
