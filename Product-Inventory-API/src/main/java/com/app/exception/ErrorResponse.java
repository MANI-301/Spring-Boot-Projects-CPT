package com.app.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ErrorResponse {
    private String message;
    private String details;
    private LocalDateTime timestamp;
    private Map<String, String> validationErrors;

    public ErrorResponse(String message, String details) {
        this.message = message;
        this.details = details;
        this.timestamp = LocalDateTime.now();
    }

    public ErrorResponse(String message, Map<String, String> errors) {
        this.message = message;
        this.validationErrors = errors;
        this.timestamp = LocalDateTime.now();
    }

    
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }  // ✅ FIXED
    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    public Map<String, String> getValidationErrors() { return validationErrors; }
    public void setValidationErrors(Map<String, String> validationErrors) { this.validationErrors = validationErrors; }
}