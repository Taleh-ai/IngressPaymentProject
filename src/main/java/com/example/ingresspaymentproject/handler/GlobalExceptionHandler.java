package com.example.ingresspaymentproject.handler;

import com.example.ingresspaymentproject.exception.ResourceNotFoundException;
import com.example.property.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDto> handleResourceNotFoundException(ResourceNotFoundException e) {
        log.info("4");
        String[] message = {e.getMessage()};
        ErrorResponse errorResponse = new ErrorResponse(message, true);
        ErrorDto errorDto = new ErrorDto(errorResponse,HttpStatus.NOT_FOUND.value(),false);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
    }

}