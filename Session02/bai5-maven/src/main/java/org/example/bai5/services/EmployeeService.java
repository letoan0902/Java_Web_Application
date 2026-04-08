package org.example.bai5.services;

import org.example.bai5.models.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();

    Optional<Employee> findByCode(String code);

    long sumSalaryByDepartment(String department);
}

