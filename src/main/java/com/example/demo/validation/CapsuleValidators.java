package com.example.demo.validation;

import com.example.demo.exception.CapsuleValidationException;
import com.example.demo.model.Capsule;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CapsuleValidators {

    public void validateAddCapsule(Capsule capsule) {
        Map<String, String> validationErrors = new HashMap<>();

        if (capsule == null) {
            throw new CapsuleValidationException("Capsule cannot be null");
        }
        if (capsule.getCapsuleId() != 0) {
            validationErrors.put("capsuleId", "Capsule ID not required");
        }
        validateDates(capsule, validationErrors);

        if (!validationErrors.isEmpty()) {
            throw new CapsuleValidationException("Validation failed", validationErrors);
        }
    }

    public void validateUpdateCapsule(Capsule capsule) {
        Map<String, String> validationErrors = new HashMap<>();

        if (capsule == null) {
            throw new CapsuleValidationException("Capsule cannot be null");
        }
        if (capsule.getCapsuleId() <= 0) {
            validationErrors.put("capsuleId", "Capsule ID must be a positive number");
        }
        validateDates(capsule, validationErrors);

        if (!validationErrors.isEmpty()) {
            throw new CapsuleValidationException("Validation failed", validationErrors);
        }
    }

    public void validateDates(Capsule capsule, Map<String, String> validationErrors) {
        LocalDate startDate = capsule.getStartDate();
        LocalDate endDate = capsule.getEndDate();

        if (startDate == null) {
            validationErrors.put("startDate", "Start date cannot be null or empty");
        }

        if (endDate == null) {
            validationErrors.put("endDate", "End date cannot be null or empty");
        }

        if (startDate != null && endDate != null && endDate.isBefore(startDate)) {
            validationErrors.put("endDate", "End date must be after start date");
        }
    }
}
