package com.example.springbootapi.service;

import com.example.springbootapi.entity.Employee;
import com.example.springbootapi.error.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployeeService {
    public Employee saveEmployee(Employee employee);

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(Long employeeId) throws EmployeeNotFoundException;

    public void deleteById(Long employeeId);

    public Employee updateEmployeeById(Long employeeId, Employee employee);

    public Employee getElementByEmail(String email);
}
