package com.maicon.crud_spring.controller;

import com.maicon.crud_spring.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AplicationControllerAdvice {

    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handlerNotFoundException(RecordNotFoundException ex) {
        return ex.getMessage();
    }
}
