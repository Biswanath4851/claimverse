package com.claimverse.authservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "division")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Division {

    @Id
    private int code;

    private String Description;// e.g., "US-HR" or "IN-FIN"

    private String name;

    private String tenantId;

    private boolean isHostingDivision;
}
