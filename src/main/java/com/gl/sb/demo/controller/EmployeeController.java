package com.gl.sb.demo.controller;

import com.gl.sb.demo.exception.EmployeeNotFoundException;
import com.gl.sb.demo.model.Employee;
import com.gl.sb.demo.service.EmployeeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    @ResponseStatus(CREATED)
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createAnEmployee(employee);

    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable(value = "id") Long employeeId) throws EmployeeNotFoundException {
        return employeeService.getAnEmployeeDetailsById(employeeId);
    }

    @PutMapping("/employees/{id}")
    @ResponseStatus(CREATED)
    public Employee updateEmployee(@PathVariable(value = "id") Long employeeId,
                                   @RequestBody Employee employeeDetails) throws EmployeeNotFoundException {
        return employeeService.updateAnEmployee(employeeId, employeeDetails);
    }

    @DeleteMapping("/employees/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteEmployee(@PathVariable(value = "id") Long employeeId) throws EmployeeNotFoundException {
        employeeService.deleteAnEmployee(employeeId);
    }

}
