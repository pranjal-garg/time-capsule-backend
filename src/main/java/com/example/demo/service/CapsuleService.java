package com.example.demo.service;

import com.example.demo.exception.CapsuleNotFoundException;
import com.example.demo.model.Capsule;
import com.example.demo.repository.CapsuleRepository;
import com.example.demo.validation.CapsuleValidators;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CapsuleService {

    private final CapsuleValidators capsuleValidator = new CapsuleValidators();
    private final CapsuleRepository capsuleRepository;

    public CapsuleService(CapsuleRepository capsuleRepository) {
        this.capsuleRepository = capsuleRepository;
    }

    public List<Capsule> getCapsules() {
        return capsuleRepository.findAll();
    }

    public Capsule getCapsuleById(int capsuleId) {
        Optional<Capsule> capsuleOpt = capsuleRepository.findById(capsuleId);
        if (capsuleOpt.isPresent()) {
            return capsuleOpt.get();
        } else throw new CapsuleNotFoundException(capsuleId);

    }

    public void addCapsule(Capsule capsule) {
        capsuleValidator.validateAddCapsule(capsule);
        updateCapsuleStatus(capsule);
        capsuleRepository.save(capsule);
    }

    public void updateCapsule(Capsule capsule) {
        capsuleValidator.validateUpdateCapsule(capsule);
        Optional<Capsule> capsuleToUpdate = capsuleRepository.findById(capsule.getId());
        if (capsuleToUpdate.isPresent()) {
            Capsule capsuleUpdate = capsuleToUpdate.get();
            capsuleUpdate.setTitle(capsule.getTitle());
            capsuleUpdate.setDescription(capsule.getDescription());
            capsuleUpdate.setEndDate(capsule.getEndDate());
            capsuleUpdate.setStartDate(capsule.getStartDate());
            updateCapsuleStatus(capsuleUpdate);
            capsuleRepository.save(capsuleUpdate);
        } else throw new CapsuleNotFoundException(capsule.getId());
    }

    public void deleteCapsule(int id) {
        if (capsuleRepository.existsById(id)) {
            capsuleRepository.deleteById(id);
        } else {
            throw new CapsuleNotFoundException(id);
        }

    }

    public void updateCapsuleStatus(Capsule capsule) {
        LocalDate today = LocalDate.now();
        capsule.setLocked(!capsule.getEndDate().isBefore(today));

    }
}
