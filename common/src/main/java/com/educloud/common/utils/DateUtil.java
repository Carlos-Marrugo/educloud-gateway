package com.educloud.common.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    
    private DateUtil() {}
    
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    private static final DateTimeFormatter DATE_FORMATTER = 
        DateTimeFormatter.ofPattern(DATE_FORMAT);
    private static final DateTimeFormatter DATE_TIME_FORMATTER = 
        DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
    
    public static String formatDate(LocalDate date) {
        return date != null ? date.format(DATE_FORMATTER) : null;
    }
    
    public static String formatDateTime(LocalDateTime dateTime) {
        return dateTime != null ? dateTime.format(DATE_TIME_FORMATTER) : null;
    }
    
    public static LocalDate parseDate(String dateString) {
        return dateString != null ? LocalDate.parse(dateString, DATE_FORMATTER) : null;
    }
    
    public static LocalDateTime parseDateTime(String dateTimeString) {
        return dateTimeString != null ? 
            LocalDateTime.parse(dateTimeString, DATE_TIME_FORMATTER) : null;
    }
    
    public static boolean isDateBetween(LocalDate date, LocalDate start, LocalDate end) {
        return date != null && start != null && end != null && 
               !date.isBefore(start) && !date.isAfter(end);
    }
}