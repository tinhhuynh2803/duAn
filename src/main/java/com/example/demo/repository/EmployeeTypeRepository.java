package com.example.demo.repository;

import com.example.demo.model.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeTypeRepository extends JpaRepository<EmployeeType, Long> {
}
