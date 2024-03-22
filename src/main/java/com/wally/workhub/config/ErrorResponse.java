package com.wally.workhub.config;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class ErrorResponse {
    private String message;
    private String code;
    private String status;
    private Map<String, String> validationErrors = new HashMap<>();

    public ErrorResponse(String message, String code, String status) {
        this.message = message;
        this.code = code;
        this.status = status;
    }

    public void addValidationError(String field, String message) {
        validationErrors.put(field, message);
    }

}
