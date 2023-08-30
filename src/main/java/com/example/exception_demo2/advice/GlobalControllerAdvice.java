package com.example.exception_demo2.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception e) {

        System.out.println(e.getClass().getName());
        System.out.println("=====================");
        System.out.println(e.getLocalizedMessage());
        System.out.println("=====================");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity nullPointerException(NullPointerException e){

        System.out.println(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
