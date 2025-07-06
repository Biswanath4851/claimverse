package com.claimverse.employeeservice.service;

import com.claimverse.employeeservice.dto.EmployeeRequest;
import com.claimverse.employeeservice.entity.Employee;
import com.claimverse.employeeservice.repo.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee createEmployee(EmployeeRequest employeeRequest, String tenantId) {
        Employee employee = Employee.builder()
                .fullName(employeeRequest.getFullName())
                .email(employeeRequest.getEmail())
                .tenantId(tenantId)
                .build();
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployeesByTenantId(String tenantId) {
        return employeeRepository.findByTenantId(tenantId);
    }

}
