package com.pizzastore.auth.controller;

import com.pizzastore.auth.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;
    public AuthController(JwtUtil jwtUtil){ this.jwtUtil = jwtUtil; }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String,String> body){
        String username = body.get("username"); String role = body.getOrDefault("role","ROLE_USER");
        // In real app validate username/password against DB
        String token = jwtUtil.generateToken(username, role);
        return ResponseEntity.ok(Map.of("token", token));
    }
}
