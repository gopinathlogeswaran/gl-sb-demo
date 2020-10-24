package com.gl.sb.demo.service;

import com.gl.sb.demo.model.Employee;
import com.gl.sb.demo.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createAnEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
