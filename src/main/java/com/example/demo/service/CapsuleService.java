package com.example.demo.service;

import com.example.demo.model.Capsule;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CapsuleService {

    List<Capsule> capsules = new ArrayList<>();

    public List<Capsule> getCapsules() {
        return capsules;
    }

    public Capsule getCapsuleById(int prodId) {
        for (Capsule p : capsules) {
            if (p.getCapsuleId() == prodId) {
                return p;
            }
        }
        return null;
    }

    public void addCapsule(Capsule capsule) {
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
