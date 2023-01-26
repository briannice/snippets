package com.briannice.snippets.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briannice.snippets.auth.request.LoginRequest;
import com.briannice.snippets.auth.request.RegisterRequest;
import com.briannice.snippets.auth.response.LoginResponse;
import com.briannice.snippets.auth.response.RegisterResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest body) {
        var result = authService.register(body);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest body) {
        var result = authService.login(body);
        return ResponseEntity.ok(result);
    }
}
