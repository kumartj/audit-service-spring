package com.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    private final Logger log = LoggerFactory.getLogger(ExceptionAdvice.class);

    /**
     * Changing the Response status to test that Changed response status is intercepted in the Audit
     */
    @ResponseStatus(HttpStatus.GATEWAY_TIMEOUT)
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
       log.info("handled the exception with message" + e.getMessage());
       return ("I have failed to process because of " + e.getMessage());
    }
}
