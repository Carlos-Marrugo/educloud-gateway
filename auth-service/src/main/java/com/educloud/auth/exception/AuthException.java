package com.educloud.auth.exception;

import lombok.Getter;

@Getter
public class AuthException extends RuntimeException {
    private final String errorCode;
    
    public AuthException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    
    public AuthException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode.name();
    }
}