package com.example.springbootapi.controller;

import com.example.springbootapi.entity.Employee;
import com.example.springbootapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return  employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployeeById(@PathVariable("id") Long employeeId,@RequestBody Employee employee){
        return  employeeService.updateEmployeeById(employeeId,employee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteById(@PathVariable("id") Long employeeId){
        employeeService.deleteById(employeeId);
        return "Delete Sucessfully!";
    }
}
