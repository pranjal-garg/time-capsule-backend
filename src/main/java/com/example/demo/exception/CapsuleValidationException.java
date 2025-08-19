package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

public class CapsuleValidationException extends CapsuleException {
    private Map<String, String> details;

    public CapsuleValidationException(String message) {
        super(message);
    }

    public CapsuleValidationException(String message, Map<String, String> details) {
        super(message);
        this.details = details;
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
}
