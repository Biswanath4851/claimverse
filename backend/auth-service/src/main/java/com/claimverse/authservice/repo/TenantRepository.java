package com.claimverse.authservice.repo;

import com.claimverse.authservice.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
    Tenant findByTenantId(String tenantId);
}
