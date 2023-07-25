package com.vagnerbohm.movies.controller;

import com.vagnerbohm.movies.document.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

import static java.time.LocalDateTime.now;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<HttpResponse> handleResponseStatusException(ResponseStatusException e) {
        HttpStatus status = (HttpStatus) e.getStatusCode();

        return ResponseEntity.status(e.getStatusCode()).body(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .message(e.getReason())
                        .status(status)
                        .statusCode(e.getStatusCode().value())
                        .build()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
