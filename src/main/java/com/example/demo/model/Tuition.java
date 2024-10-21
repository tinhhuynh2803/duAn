package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tuition")
public class Tuition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Double originalPrice;
	
	@Column(nullable = false)
	private Double promotionalPrice;
	
	@ManyToOne // Nhiều tuition có thể thuộc về một course
    @JoinColumn(name = "course_id", nullable = false) // Khóa ngoại liên kết đến Course
    private Course course; // Liên kết với Course
}