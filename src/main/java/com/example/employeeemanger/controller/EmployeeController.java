package com.example.employeeemanger.controller;

import com.example.employeeemanger.model.Employee;
import com.example.employeeemanger.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee()
    {
        List<Employee> employees=employeeService.findAllEmployee();
        return  new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id)
    {
        Employee employee=employeeService.findEmployeeById(id);
        return  new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @PostMapping("/add")
    public   ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee=employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public   ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee=employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletEmployee(@PathVariable("id") Long id)
    {
        employeeService.deleteEmployee(id);
       return   new ResponseEntity<>(HttpStatus.OK);
    }

}
