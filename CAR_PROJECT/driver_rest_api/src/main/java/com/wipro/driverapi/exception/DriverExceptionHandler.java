package com.wipro.driverapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DriverExceptionHandler {
    
    @ExceptionHandler({Exception.class})
    public ResponseEntity<String> handleAnyExp(Exception e) {
        // Log the exception or handle it as needed
        // System.out.println("I am  Global Exp Handler handle exp");
        
        return new ResponseEntity<String>(e.toString(), HttpStatus.BAD_REQUEST);
    }
}
