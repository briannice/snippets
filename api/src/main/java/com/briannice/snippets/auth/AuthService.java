package com.briannice.snippets.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.briannice.snippets.auth.request.LoginRequest;
import com.briannice.snippets.auth.request.RegisterRequest;
import com.briannice.snippets.auth.response.LoginResponse;
import com.briannice.snippets.auth.response.RegisterResponse;
import com.briannice.snippets.jwt.JwtService;
import com.briannice.snippets.user.User;
import com.briannice.snippets.user.UserRepository;
import com.briannice.snippets.user.UserRole;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public RegisterResponse register(RegisterRequest registerRequest) {
        var user = User
                .builder()
                .username(registerRequest.getUsername())
                .firstname(registerRequest.getFirstname())
                .lastname(registerRequest.getLastname())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(UserRole.USER)
                .build();

        userRepository.save(user);

        var token = jwtService.generateToken(user);

        var result = RegisterResponse
                .builder()
                .username(user.getUsername())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .token(token)
                .build();

        return result;
    }

    public LoginResponse login(LoginRequest loginRequest) {
        var username = loginRequest.getUsername();
        var password = loginRequest.getPassword();

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        var user = userRepository.findByUsername(username).orElseThrow();
        var token = jwtService.generateToken(user);

        var result = LoginResponse
                .builder()
                .username(user.getUsername())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .token(token)
                .build();

        return result;
    }
}
