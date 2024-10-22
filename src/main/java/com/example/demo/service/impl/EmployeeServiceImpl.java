package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(employee.getId()).orElseThrow();
        existingEmployee.setFullName(employee.getFullName());
        existingEmployee.setDateOfBirth(employee.getDateOfBirth());
        existingEmployee.setGender(employee.getGender());
        existingEmployee.setNationalID(employee.getNationalID());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhoneNumber(employee.getPhoneNumber());
        existingEmployee.setActivation(employee.getActivation());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
