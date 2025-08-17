package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "🕰️ Welcome to the Time Capsule API – Preserve your memories for the future. Visit /capsule to get started!";
    }
}
