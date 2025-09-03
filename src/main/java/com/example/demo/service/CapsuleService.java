package com.example.demo.service;

import com.example.demo.exception.CapsuleNotFoundException;
import com.example.demo.model.Capsule;
import com.example.demo.validation.CapsuleValidators;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        capsuleValidator.validateAddCapsule(capsule);
        updateCapsuleId(capsule);
        updateCapsuleStatus(capsule);
        capsules.add(capsule);
    }

    public void updateCapsule(Capsule capsule) {
        capsuleValidator.validateUpdateCapsule(capsule);
        updateCapsuleStatus(capsule);
        for (Capsule p : capsules) {
            if (p.getCapsuleId() == capsule.getCapsuleId()) {
                p.updateCapsule(capsule);
                return;
            }
        }
        throw new CapsuleNotFoundException(capsule.getCapsuleId());
    }

    public void deleteCapsule(int capsuleId) {
        for (int i = 0; i < capsules.size(); i++) {
            if (capsules.get(i).getCapsuleId() == capsuleId) {
                capsules.remove(i);
                return;
            }
        }
        throw new CapsuleNotFoundException(capsuleId);
    }

    public void updateCapsuleId(Capsule capsule)
    {
        capsule.setCapsuleId(capsules.size() + 1);
    }

    public void updateCapsuleStatus(Capsule capsule) {
        LocalDate today = LocalDate.now();
        capsule.isLocked(!capsule.getEndDate().isBefore(today));
    }
}
