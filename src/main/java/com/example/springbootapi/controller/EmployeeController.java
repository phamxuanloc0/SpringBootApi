package com.example.springbootapi.controller;

import com.example.springbootapi.entity.Employee;
import com.example.springbootapi.error.EmployeeNotFoundException;
import com.example.springbootapi.service.EmployeeService;
import com.example.springbootapi.service.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.persistence.TableGenerator;
import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(EmployeeController.class);


    @PostMapping("/employees")
    public Employee saveEmployee(@Valid @RequestBody Employee employee){

        LOGGER.info("Inside saveEmployee of EmployeeController!");

        return employeeService.saveEmployee(employee);
    }
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){

        LOGGER.info("Inside getAllEmployees of EmployeeController!");
        return employeeService.getAllEmployees();
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long employeeId)
            throws EmployeeNotFoundException {
        return employeeService.getEmployeeById(employeeId);
    }
    @DeleteMapping("/employees/{id}")
    public String deleteById(@PathVariable("id") Long employeeId){
        employeeService.deleteById(employeeId);
        return "Successfully!";
    }
    @PutMapping("/employees/{id}")
    public Employee updateEmployeeById(@PathVariable("id") Long employeeId,
                                       @RequestBody Employee employee){

        return employeeService.updateEmployeeById(employeeId, employee);
    }
    @GetMapping("/employees/email/{email}")
    public Employee getElementByEmail(@PathVariable("email") String email){
        return employeeService.getElementByEmail(email);
    }
}
