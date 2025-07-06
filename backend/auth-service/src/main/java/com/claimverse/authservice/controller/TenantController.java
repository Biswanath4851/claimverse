package com.claimverse.authservice.controller;

import com.claimverse.authservice.entity.Tenant;
import com.claimverse.authservice.service.TenantService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tenant")
@RequiredArgsConstructor
public class TenantController {

    private final TenantService tenantService;
    @GetMapping("/me")
    public ResponseEntity<List<Tenant>> getMe(){
        return ResponseEntity.ok(tenantService.getAllTenants());
    }
}
