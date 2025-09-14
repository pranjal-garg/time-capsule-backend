package com.example.demo.controller;

import com.example.demo.model.Capsule;
import com.example.demo.service.CapsuleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/capsule")
public class CapsuleController {

    private static final Logger logger = LoggerFactory.getLogger(CapsuleController.class);

    @Autowired
    CapsuleService service;

    @GetMapping
    public List<Capsule> getCapsules() {
        return service.getCapsules();
    }

    @GetMapping("/{capsuleId}")
    public Capsule getCapsuleById(@PathVariable int capsuleId) {
        return service.getCapsuleById(capsuleId);
    }

    @PostMapping
    public void addCapsule(@RequestBody Capsule capsule) {
        service.addCapsule(capsule);
    }

    @PutMapping
    public void updateCapsule(@RequestBody Capsule capsule) {
        service.updateCapsule(capsule);
    }

    @DeleteMapping("/{capsuleId}")
    public void deleteCapsuleById(@PathVariable int capsuleId) {
        service.deleteCapsule(capsuleId);
    }
}
