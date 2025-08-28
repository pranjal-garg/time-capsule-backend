package com.example.demo.validation;

import com.example.demo.exception.CapsuleAlreadyExistsException;
import com.example.demo.exception.CapsuleValidationException;
import com.example.demo.model.Capsule;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.List;
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
        if (capsule.getTitle() == null || capsule.getTitle().trim().isEmpty()) {
            validationErrors.put("title", "Title cannot be null or empty");
        }

        if (capsule.getMessage() == null || capsule.getMessage().trim().isEmpty()) {
            validationErrors.put("message", "Message cannot be null or empty");
        }

        validateDates(capsule, validationErrors);

        if (!validationErrors.isEmpty()) {
            throw new CapsuleValidationException("Validation failed", validationErrors);
        }


    }

    public void validateCapsule(Capsule capsule) {
        Map<String, String> validationErrors = new HashMap<>();

        if (capsule == null) {
            throw new CapsuleValidationException("Capsule cannot be null");
        }

        if (capsule.getCapsuleId() <= 0) {
            validationErrors.put("capsuleId", "Capsule ID must be a positive number");
        }

        if (capsule.getTitle() == null || capsule.getTitle().trim().isEmpty()) {
            validationErrors.put("title", "Title cannot be null or empty");
        }

        if (capsule.getMessage() == null || capsule.getMessage().trim().isEmpty()) {
            validationErrors.put("message", "Message cannot be null or empty");
        }

        validateDates(capsule, validationErrors);

        if (!validationErrors.isEmpty()) {
            throw new CapsuleValidationException("Validation failed", validationErrors);
        }
    }

    public void validateDates(Capsule capsule, Map<String, String> validationErrors) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate startDate = null;
        LocalDate endDate = null;

        if (capsule.getStartDate() == null || capsule.getStartDate().trim().isEmpty()) {
            validationErrors.put("startDate", "Start date cannot be null or empty");
        } else {
            try {
                startDate = LocalDate.parse(capsule.getStartDate(), formatter);
                // Allow any start date - no past date restriction
            } catch (DateTimeParseException e) {
                validationErrors.put("startDate", "Start date must be in format dd-MM-yyyy");
            }
        }

        if (capsule.getEndDate() == null || capsule.getEndDate().trim().isEmpty()) {
            validationErrors.put("endDate", "End date cannot be null or empty");
        } else {
            try {
                endDate = LocalDate.parse(capsule.getEndDate(), formatter);
                // Allow any end date - no past date restriction
            } catch (DateTimeParseException e) {
                validationErrors.put("endDate", "End date must be in format dd-MM-yyyy");
            }
        }

        if (startDate != null && endDate != null && endDate.isBefore(startDate)) {
            validationErrors.put("endDate", "End date must be after start date");
        }
    }

    public void checkForDuplicateId(int capsuleId, List<Capsule> capsules) {
        for (Capsule existingCapsule : capsules) {
            if (existingCapsule.getCapsuleId() == capsuleId) {
                throw new CapsuleAlreadyExistsException(capsuleId);
            }
        }
    }
}
