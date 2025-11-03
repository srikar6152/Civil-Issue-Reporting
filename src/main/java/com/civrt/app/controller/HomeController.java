package com.civrt.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Tells Spring this class will handle web requests
public class HomeController {
    @GetMapping("/") // Maps this method to the root URL (http://localhost:8080/)
    public String home() {
        return "Welcome to the Civil Issue Reporting Platform!";
    }
}
