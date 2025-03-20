package com.example.employeeemanger.repository;

import com.example.employeeemanger.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
}
