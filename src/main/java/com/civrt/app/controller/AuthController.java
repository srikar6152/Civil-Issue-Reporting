package com.civrt.app.controllers;  // <-- make sure this is inside your project base package

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, Object> body) {
        System.out.println("Register endpoint HIT");
        System.out.println(body);

        return ResponseEntity.ok(Map.of(
                "success", true,
                "message", "User registered successfully"
        ));
    }
}
