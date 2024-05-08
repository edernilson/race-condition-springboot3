package com.edernilson.bank.adapters.in.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.edernilson.bank.domain.exception.ResponseStatusException;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 09/04/2024, terça-feira
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    
    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiError> handleDomainException(ResponseStatusException domainError) {
        return ResponseEntity
                .status(domainError.getStatusCode())
                .body(new ApiError(domainError.getMessage()));
    } 
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleDomainException(Exception unexpectedError) {
        String message = "Ops! Ocorreu um erro inesperado!";
        log.error(message, unexpectedError);
        return ResponseEntity
                .internalServerError()
                .body(new ApiError(message));
    }    
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiError> handleDomainException(HttpMessageNotReadableException jsonError) {
        String message = "Ops! Formato do envio invalido!";
        log.error(message, jsonError);
        return ResponseEntity
                .internalServerError()
                .body(new ApiError(message));
    }
    
    public record ApiError(String message) {
    }
}