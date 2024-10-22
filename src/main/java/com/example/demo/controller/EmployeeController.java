package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping
    public List<Employee> getAllEmployee(){
        return iEmployeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = iEmployeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee createEmployee = iEmployeeService.createEmployee(employee);
        return ResponseEntity.ok(createEmployee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        Employee updateEmployee = iEmployeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id){
        iEmployeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
