package com.claimverse.authservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@Tag(name = "Test Controller", description = "Test secured endpoints")
public class TestController {

    @GetMapping("/hello")
    @Operation(summary = "Authenticated Hello", description = "Returns greeting if JWT is valid")
    public ResponseEntity<String> hello() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("🔐 Auth object: " + auth);

        if (auth == null || !auth.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("❌ Not authenticated");
        }

        return ResponseEntity.ok("Hello! You are authenticated 🎉");
    }

    @GetMapping("/adminOnly")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> adminOnly() {
        return ResponseEntity.ok("Admin only endpoint is working!");
    }
}


