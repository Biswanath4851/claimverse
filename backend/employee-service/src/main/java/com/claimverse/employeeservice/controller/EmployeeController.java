package com.claimverse.employeeservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @GetMapping("/me")
    public ResponseEntity<String> getMe(HttpServletRequest request) {
        String email = (String) request.getAttribute("email");
        return ResponseEntity.ok("You are logged in as: " + email);
    }
}
