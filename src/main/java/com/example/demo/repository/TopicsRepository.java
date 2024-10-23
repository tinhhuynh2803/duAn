package com.example.demo.repository;

import com.example.demo.model.Topics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicsRepository extends JpaRepository<Topics, Long> {
}
