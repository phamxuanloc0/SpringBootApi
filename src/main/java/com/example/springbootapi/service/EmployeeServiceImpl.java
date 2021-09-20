package com.example.springbootapi.service;

import com.example.springbootapi.entity.Employee;
import com.example.springbootapi.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    @Override
    public void deleteById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public Employee updateEmployeeById(Long employeeId,
                                       Employee employeeNew) {
        Employee employeeDB =
                employeeRepository.findById(employeeId).get();

        if(Objects.nonNull(employeeNew.getFirstName()) &&
                !"".equalsIgnoreCase(employeeNew.getFirstName())){

            employeeDB.setFirstName(employeeNew.getFirstName());
        }
        if(Objects.nonNull(employeeNew.getLastName()) &&
                !"".equalsIgnoreCase(employeeNew.getLastName())){
            employeeDB.setLastName(employeeNew.getLastName());

        }
        if(Objects.nonNull(employeeNew.getEmail()) &&
                !"".equalsIgnoreCase(employeeNew.getEmail())){
            employeeDB.setEmail(employeeNew.getEmail());
        }

        return employeeRepository.save(employeeDB);
    }
}
