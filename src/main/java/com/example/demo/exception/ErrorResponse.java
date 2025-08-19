package com.example.demo.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ErrorResponse {

    private String errorCode;
    private String message;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    private String path;
    private Map<String, String> details;

    public ErrorResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public ErrorResponse(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public static ErrorResponse notFound(String message, String path) {
        ErrorResponse response = new ErrorResponse("NOT_FOUND", message);
        response.setPath(path);
        return response;
    }

    public static ErrorResponse badRequest(String message, String path) {
        ErrorResponse response = new ErrorResponse("BAD_REQUEST", message);
        response.setPath(path);
        return response;
    }

    public static ErrorResponse conflict(String message, String path) {
        ErrorResponse response = new ErrorResponse("CONFLICT", message);
        response.setPath(path);
        return response;
    }

    public static ErrorResponse validationError(String message, String path) {
        ErrorResponse response = new ErrorResponse("VALIDATION_ERROR", message);
        response.setPath(path);
        return response;
    }

    public static ErrorResponse internalError(String path) {
        ErrorResponse response = new ErrorResponse("INTERNAL_SERVER_ERROR", "An unexpected error occurred");
        response.setPath(path);
        return response;
    }

    public static ErrorResponse fieldValidationError(String path, Map<String, String> fieldErrors) {
        ErrorResponse response = new ErrorResponse("VALIDATION_ERROR", "Multiple validation errors occurred");
        response.setPath(path);
        response.setDetails(fieldErrors);
        return response;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getDetails() {
        return details;
    }

    public void setDetails(Map<String, String> details) {
        this.details = details;
    }

    public void addDetail(String key, String value) {
        if (this.details == null) {
            this.details = new HashMap<>();
        }
        this.details.put(key, value);
    }

    public boolean hasDetails() {
        return details != null && !details.isEmpty();
    }
}