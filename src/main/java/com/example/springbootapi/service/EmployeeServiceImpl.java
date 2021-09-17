package com.example.springbootapi.service;

import com.example.springbootapi.Repository.EmployeeRepository;
import com.example.springbootapi.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> lists= new ArrayList<Employee>();
        employeeRepository.findAll().forEach(list1->lists.add(list1));
        return lists;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployeeById(Long id, Employee employee) {
        Employee employeeDB= employeeRepository.findById(id).get();
        if(Objects.nonNull(employee.getFirstName()) &&
                !"".equalsIgnoreCase(employee.getFirstName())){
            employeeDB.setFirstName(employee.getFirstName());
        }
        if(Objects.nonNull(employee.getLastName()) &&
                !"".equalsIgnoreCase(employee.getLastName())){
            employeeDB.setLastName(employee.getLastName());
        }
        if(Objects.nonNull(employee.getEmail()) &&
                !"".equalsIgnoreCase(employee.getEmail())){
            employeeDB.setEmail(employee.getEmail());
        }
        return employeeRepository.save(employeeDB);
    }
}
