package com.edernilson.bank.domain.exception;

import org.springframework.http.HttpStatus;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 06/05/2024, segunda-feira
 */
public class ResponseStatusException extends RuntimeException {
    private final HttpStatus statusCode;

    public ResponseStatusException(HttpStatus statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
}