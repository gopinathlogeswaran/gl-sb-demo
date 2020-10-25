package com.gl.sb.demo.service;

import com.gl.sb.demo.exception.EmployeeNotFoundException;
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

    public Employee getAnEmployeeDetailsById(Long employeeId) throws EmployeeNotFoundException {
        return employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException(String.format("Employee not found for this id :: %d", employeeId)));
    }

    public Employee updateAnEmployee(Long employeeId, Employee employeeDetails) throws EmployeeNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                                              .orElseThrow(() -> new EmployeeNotFoundException(String.format("Employee not found for this id :: %d", employeeId)));

        employee.setEmailId(employeeDetails.getEmailId());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        return employeeRepository.save(employee);
    }

    public void deleteAnEmployee(Long employeeId) throws EmployeeNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                                              .orElseThrow(() -> new EmployeeNotFoundException(String.format("Employee not found for this id :: %d", employeeId)));
        employeeRepository.delete(employee);

    }
}
