package com.claimverse.authservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tenant")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tenant {

    @Id
    @Column(name = "tenant_id", nullable = false, unique = true)
    private String id; // UUID string like "tenant_acme_001"

    private String name;

    @Enumerated(EnumType.STRING)
    private SubscriptionPlan subscriptionPlan;

    private int maxEmployees;

    private boolean dedicatedDb; // true = Premium, false = Shared

    private String hostingDivision; // could also be a relation
}
