package com.claimverse.authservice.service;

import com.claimverse.authservice.dto.LoginRequest;
import com.claimverse.authservice.dto.RegisterRequest;
import com.claimverse.authservice.entity.Role;
import com.claimverse.authservice.entity.User;
import com.claimverse.authservice.repo.UserRepository;
import com.claimverse.authservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String register(RegisterRequest request){
        var user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole() != null ? request.getRole() : Role.EMPLOYEE)
                .build();
        userRepo.save(user);
        return jwtService.generateToken(user);
    }

    public String login(LoginRequest loginRequest){
        var user = userRepo.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtService.generateToken(user);
    }
}