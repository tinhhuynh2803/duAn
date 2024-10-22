package com.example.demo.service;

import com.example.demo.model.EmployeeType;

import java.util.List;

public interface IEmployeeTypeService {
    public List<EmployeeType> getAllEmployeeType();
    public EmployeeType getEmployeeTypeById(Long id);
    public EmployeeType createEmployeeType(EmployeeType employeeType);
    public EmployeeType updateEmployeeType(Long id, EmployeeType employeeType);
    public void deleteEmployeeType(Long id);
}
