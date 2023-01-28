package com.briannice.snippets.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briannice.snippets.auth.request.LoginRequest;
import com.briannice.snippets.auth.request.RegisterRequest;
import com.briannice.snippets.auth.response.LoginResponse;
import com.briannice.snippets.auth.response.RegisterResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest body) {
        var result = authService.register(body);
        return new ResponseEntity<RegisterResponse>(result, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest body) {
        var result = authService.login(body);
        return new ResponseEntity<LoginResponse>(result, HttpStatus.OK);
    }
}
