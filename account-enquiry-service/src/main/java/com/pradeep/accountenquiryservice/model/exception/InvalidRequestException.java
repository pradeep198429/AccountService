package com.pradeep.accountenquiryservice.model.exception;

import org.springframework.http.HttpStatus;

public class InvalidRequestException extends RuntimeException{
    private HttpStatus httpStatus;

    public InvalidRequestException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
