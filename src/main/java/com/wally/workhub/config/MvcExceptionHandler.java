package com.wally.workhub.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Slf4j
@RestControllerAdvice
public class MvcExceptionHandler {
    // ResponseEntityExceptionHandler 상송 받는것도 있던데. https://mangkyu.tistory.com/205


    // @Valid에 걸리는거 처리
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse invalidRequestHandler(MethodArgumentNotValidException e) {
        ErrorResponse errorResponse = new ErrorResponse("Invalid request", "400", "BAD_REQUEST");

        for (FieldError fieldError : e.getFieldErrors()) {
            log.info(fieldError.getDefaultMessage());
            errorResponse.addValidationError(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return errorResponse;
    }

}
