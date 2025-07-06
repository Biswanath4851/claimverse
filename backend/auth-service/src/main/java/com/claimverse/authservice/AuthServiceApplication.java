package com.claimverse.authservice;

import com.claimverse.authservice.entity.Division;
import com.claimverse.authservice.entity.SubscriptionPlan;
import com.claimverse.authservice.entity.Tenant;
import com.claimverse.authservice.repo.DivisionRepository;
import com.claimverse.authservice.repo.TenantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner init(TenantRepository tenantRepo, DivisionRepository divisionRepo) {
		return args -> {
			Tenant t1 = Tenant.builder()
					.id("acme")
					.name("Acme Corp")
					.subscriptionPlan(SubscriptionPlan.BASIC)
					.maxEmployees(10)
					.dedicatedDb(false)
					.hostingDivision("ACME-HOST")
					.build();
			tenantRepo.save(t1);

			Tenant t2 = Tenant.builder()
					.id("demo-tenant-id")
					.name("Demo Tenant")
					.subscriptionPlan(SubscriptionPlan.BASIC)
					.maxEmployees(10)
					.dedicatedDb(false)
					.hostingDivision("DEMO-HOST")
					.build();
			tenantRepo.save(t2);

			divisionRepo.save(Division.builder()
					.code(1)
					.Description("ACME-HOST")
					.name("Hosting Division")
					.tenantId("acme")
					.isHostingDivision(true)
					.build());

			divisionRepo.save(Division.builder()
					.code(10001)
					.Description("ACME-FIN")
					.name("Finance Division")
					.tenantId("acme")
					.isHostingDivision(false)
					.build());
		};
	}

}
