package com.educloud.common.security;

public class TenantContext {
    
    private static final ThreadLocal<String> CURRENT_TENANT = new ThreadLocal<>();
    private static final ThreadLocal<String> CURRENT_USER_ID = new ThreadLocal<>();
    private static final ThreadLocal<String> CURRENT_USER_ROLE = new ThreadLocal<>();
    
    private TenantContext() {
    }
    
    public static void setCurrentTenant(String tenantId) {
        CURRENT_TENANT.set(tenantId);
    }
    
    public static String getCurrentTenant() {
        return CURRENT_TENANT.get();
    }
    
    public static void clearCurrentTenant() {
        CURRENT_TENANT.remove();
    }
    
    public static void setCurrentUserId(String userId) {
        CURRENT_USER_ID.set(userId);
    }
    
    public static String getCurrentUserId() {
        return CURRENT_USER_ID.get();
    }
    
    public static void clearCurrentUserId() {
        CURRENT_USER_ID.remove();
    }
    
    public static void setCurrentUserRole(String role) {
        CURRENT_USER_ROLE.set(role);
    }
    
    public static String getCurrentUserRole() {
        return CURRENT_USER_ROLE.get();
    }
    
    public static void clearCurrentUserRole() {
        CURRENT_USER_ROLE.remove();
    }
    
    public static void clearAll() {
        clearCurrentTenant();
        clearCurrentUserId();
        clearCurrentUserRole();
    }
}