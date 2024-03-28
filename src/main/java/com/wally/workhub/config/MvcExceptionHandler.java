package com.wally.workhub.config;

import com.wally.workhub.common.ErrorResponse;
import com.wally.workhub.exception.WorkhubException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class MvcExceptionHandler {
    // ResponseEntityExceptionHandler 상송 받는것도 있던데. https://mangkyu.tistory.com/205


    // @Valid에 걸리는거 처리
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse invalidRequestHandler(MethodArgumentNotValidException e) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message("Invalid Request")
                .code("400")
                .status(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .build();

        for (FieldError fieldError : e.getFieldErrors()) {
            log.info(fieldError.getDefaultMessage());
            errorResponse.addValidationError(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return errorResponse;
    }

    @ResponseBody
    @ExceptionHandler(WorkhubException.class)
    public ResponseEntity<ErrorResponse> workhubException(WorkhubException e) {
        int statusCode = e.getStatusCode();

        ErrorResponse build = ErrorResponse.builder()
                .message(e.getMessage())
                .code(String.valueOf(statusCode))
                .status(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .validation(e.getValidation())
                .build();

        return ResponseEntity.status(statusCode)
                .body(build);

    }
}
