package com.jbb.userservice.controller;

import com.jbb.userservice.exception.UserServiceException;
import com.jbb.userservice.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;

@Slf4j
@ControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ErrorResponse invalidRequestHandler(MethodArgumentNotValidException e) {
        ErrorResponse response = ErrorResponse.builder()
                                              .code(HttpStatus.BAD_REQUEST.value())
                                              .message(e.getMessage())
                                              .validation(new HashMap<>())
                                              .build();

        for (FieldError fieldError : e.getFieldErrors()) {
            response.addValidation(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return response;
    }

    @ExceptionHandler(UserServiceException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> serviceExceptionHandler(UserServiceException e) {
        int statusCode = e.getStatusCode();

        ErrorResponse error =  ErrorResponse.builder()
                                            .code(statusCode)
                                            .message(e.getMessage())
                                            .validation(e.getValidation())
                                            .build();

        ResponseEntity<ErrorResponse> response = ResponseEntity.status(statusCode)
                                                               .body(error);

        return response;
    }

}
