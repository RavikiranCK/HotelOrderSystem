package com.example.rk.hotelmgmt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RestResponseException extends ResponseEntityExceptionHandler {

    public RestResponseException(String message) {
        super();
    }

}