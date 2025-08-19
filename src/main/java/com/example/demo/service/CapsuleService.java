package com.example.demo.service;

import com.example.demo.exception.CapsuleNotFoundException;
import com.example.demo.model.Capsule;
import com.example.demo.validation.CapsuleValidators;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CapsuleService {

    private final CapsuleValidators capsuleValidator = new CapsuleValidators();
    List<Capsule> capsules = new ArrayList<>();

    public List<Capsule> getCapsules() {
        return capsules;
    }

    public Capsule getCapsuleById(int capsuleId) {
        for (Capsule p : capsules) {
            if (p.getCapsuleId() == capsuleId) {
                return p;
            }
        }
        throw new CapsuleNotFoundException(capsuleId);
    }

    public void addCapsule(Capsule capsule) {
        capsuleValidator.validateCapsule(capsule);
        capsuleValidator.checkForDuplicateId(capsule.getCapsuleId(), capsules);
        capsules.add(capsule);
    }

    public void updateCapsule(Capsule capsule) {
        for (Capsule p : capsules) {
            if (p.getCapsuleId() == capsule.getCapsuleId()) {
                p.setTitle(capsule.getTitle());
                p.setMessage(capsule.getMessage());
                p.setStartDate(capsule.getStartDate());
                p.setEndDate(capsule.getEndDate());
            }
        }
    }

    public void deleteProduct(int prodId) {
        capsules.removeIf(p -> p.getCapsuleId() == prodId);
    }
}
