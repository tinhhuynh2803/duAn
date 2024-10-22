package com.example.demo.controller;

import com.example.demo.model.EmployeeType;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.IEmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employeetype")
public class EmployeeTypeController {

    @Autowired
    private IEmployeeTypeService iEmployeeTypeService;

    @GetMapping
    public List<EmployeeType> getAllEmployeeType(){
        return iEmployeeTypeService.getAllEmployeeType();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeType> getEmployeeTypeById(@PathVariable Long id){
        EmployeeType employeeType = iEmployeeTypeService.getEmployeeTypeById(id);
        return ResponseEntity.ok(employeeType);
    }

    @PostMapping
    public ResponseEntity<EmployeeType> createEmployeeType(@RequestBody EmployeeType employeeType){
        EmployeeType createEmployeeType = iEmployeeTypeService.createEmployeeType(employeeType);
        return ResponseEntity.ok(createEmployeeType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeType> updateEmployeeType(@PathVariable Long id, @RequestBody EmployeeType employeeType){
        EmployeeType updateEmployeeType = iEmployeeTypeService.updateEmployeeType(id, employeeType);
        return ResponseEntity.ok(updateEmployeeType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeType> deleteEmployeeType(@PathVariable Long id){
        iEmployeeTypeService.deleteEmployeeType(id);
        return ResponseEntity.noContent().build();
    }
}
