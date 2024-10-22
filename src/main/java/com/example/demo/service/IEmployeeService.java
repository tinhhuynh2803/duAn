package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> getAllEmployee();
    public Employee getEmployeeById(Long id);
    public Employee createEmployee(Employee employee);
    public Employee updateEmployee(Long id, Employee employee);
    public void deleteEmployee(Long id);
}
