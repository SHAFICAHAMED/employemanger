package com.example.employeeemanger.service;

import com.example.employeeemanger.exceptions.UserNotFoundexception;
import com.example.employeeemanger.model.Employee;
import com.example.employeeemanger.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public Employee addEmployee(Employee employee)
    {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return  employeeRepo.save(employee);
    }
    public List<Employee> findAllEmployee(){
        return  employeeRepo.findAll();
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findById(id).orElseThrow();
    }

    public  Employee updateEmployee(Employee employee){
        return  employeeRepo.save(employee);
    }
    public void  deleteEmployee(Long id)
    {
        employeeRepo.deleteById(id);
    }




}
