package com.claimverse.employeeservice.controller;

import com.claimverse.employeeservice.dto.EmployeeRequest;
import com.claimverse.employeeservice.entity.Employee;
import com.claimverse.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/me")
    public ResponseEntity<String> getMe(HttpServletRequest request) {
        String email = (String) request.getAttribute("email");
        return ResponseEntity.ok("You are logged in as: " + email);
    }

    @PostMapping
    public ResponseEntity<String> createEmployee(
            @RequestBody EmployeeRequest employeeRequest,
            HttpServletRequest request) {
        String tenantId = (String) request.getAttribute("tenantId");
        Employee employee = employeeService.createEmployee(employeeRequest, tenantId);
        return ResponseEntity.ok("Employee created with ID: " + employee);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(HttpServletRequest request) {
        String tenantId =(String) request.getAttribute("tenantId");// Replace with actual tenant later
        return ResponseEntity.ok(employeeService.getEmployeesByTenantId(tenantId));
    }
}
