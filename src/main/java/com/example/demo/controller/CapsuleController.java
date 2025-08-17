package com.example.demo.controller;

import com.example.demo.model.Capsule;
import com.example.demo.service.CapsuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/capsule")
public class CapsuleController {

    @Autowired
    CapsuleService service;

    @GetMapping
    public List<Capsule> getCapsules() {
        return service.getCapsules();
    }

    @GetMapping("/{capsuleId}")
    public Capsule getProductById(@PathVariable int capsuleId) {
        return service.getCapsuleById(capsuleId);
    }

    @PostMapping
    public void addProduct(@RequestBody Capsule capsule) {
        System.out.println(capsule);
        service.addCapsule(capsule);
    }

    @PutMapping
    public void updateProduct(@RequestBody Capsule capsule) {
        service.updateCapsule(capsule);
    }

    @DeleteMapping("/{capsuleId}")
    public void deleteProductById(@PathVariable int capsuleId) {
        service.deleteProduct(capsuleId);
    }
}
