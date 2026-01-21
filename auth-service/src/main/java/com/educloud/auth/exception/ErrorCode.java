package com.educloud.auth.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    AUTH_001("Email already exists"),
    AUTH_002("User not found"),
    AUTH_003("User account is disabled"),
    AUTH_004("Invalid token"),
    AUTH_005("Invalid credentials"),
    AUTH_006("Access denied"),
    
    VAL_001("Validation failed"),
    
    SYS_001("Internal server error");
    
    private final String message;
    
    ErrorCode(String message) {
        this.message = message;
    }
}