package com.example.demo.repository;

import com.example.demo.model.Major;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorRepository extends JpaRepository<Major, Long> {
}
