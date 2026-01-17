package com.educloud.common.security;

public class SecurityConstants {
    
    // Header names
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String TENANT_HEADER = "X-Tenant-ID";
    public static final String USER_ID_HEADER = "X-User-ID";
    public static final String USER_ROLE_HEADER = "X-User-Role";
    
    // Token prefix
    public static final String TOKEN_PREFIX = "Bearer ";
    
    // System roles
    public static final String ROLE_SUPER_ADMIN = "SUPER_ADMIN";
    public static final String ROLE_UNIVERSITY_ADMIN = "UNIVERSITY_ADMIN";
    public static final String ROLE_COORDINATOR = "COORDINATOR";
    public static final String ROLE_PROFESSOR = "PROFESSOR";
    public static final String ROLE_STUDENT = "STUDENT";
    
    // Permission scopes
    public static final String SCOPE_READ = "read";
    public static final String SCOPE_WRITE = "write";
    public static final String SCOPE_DELETE = "delete";
    public static final String SCOPE_MANAGE = "manage";
    
    // API paths
    public static final String[] PUBLIC_PATHS = {
        "/api/v1/auth/**",
        "/api/v1/public/**",
        "/actuator/**",
        "/v3/api-docs/**",
        "/swagger-ui/**",
        "/swagger-ui.html",
        "/webjars/**"
    };
    
    // Error messages
    public static final String INVALID_TOKEN = "Invalid or expired token";
    public static final String ACCESS_DENIED = "Access denied";
    public static final String TENANT_REQUIRED = "Tenant ID is required";
}