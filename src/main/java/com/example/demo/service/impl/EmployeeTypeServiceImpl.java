package com.example.demo.service.impl;

import com.example.demo.model.EmployeeType;
import com.example.demo.repository.EmployeeTypeRepository;
import com.example.demo.service.IEmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeTypeServiceImpl implements IEmployeeTypeService {

    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    @Override
    public List<EmployeeType> getAllEmployeeType() {
        return employeeTypeRepository.findAll();
    }

    @Override
    public EmployeeType getEmployeeTypeById(Long id) {
        return employeeTypeRepository.findById(id).orElseThrow();
    }

    @Override
    public EmployeeType createEmployeeType(EmployeeType employeeType) {
        return employeeTypeRepository.save(employeeType);
    }

    @Override
    public EmployeeType updateEmployeeType(Long id, EmployeeType employeeType) {
        EmployeeType existingEmployeeType = employeeTypeRepository.findById(id).orElseThrow();
        existingEmployeeType.setEmployeeTypeName(employeeType.getEmployeeTypeName());
        return employeeTypeRepository.save(existingEmployeeType);
    }

    @Override
    public void deleteEmployeeType(Long id) {

    }
}
