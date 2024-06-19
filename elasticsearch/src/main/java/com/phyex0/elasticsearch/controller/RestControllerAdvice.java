package com.phyex0.elasticsearch.controller;

import com.phyex0.elasticsearch.exception.UserAlreadyExistException;
import com.phyex0.elasticsearch.exception.UserNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestControllerAdvice {

    @ExceptionHandler({UserAlreadyExistException.class, UserNotFoundException.class})
    @ResponseBody
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    //TODO: date parsing error must handled.
}
