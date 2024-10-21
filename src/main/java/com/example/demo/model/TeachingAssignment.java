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
@Table(name = "teachingassignment")
public class TeachingAssignment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Boolean activate;
	
	// Mối quan hệ N:1 với Employee
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee; // Nhân viên đảm nhận phân công giảng dạy

    // Mối quan hệ N:1 với Course
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false) // Khóa ngoại liên kết đến Course
    private Course course; // Khóa học được phân công giảng dạy
    
    // Mối quan hệ N:1 với SubjectAssignment
    @ManyToOne
    @JoinColumn(name = "subjectassignment_id", nullable = false) // Khóa ngoại liên kết đến SubjectAssignment
    private SubjectAssignment subjectAssignment; // Môn học được phân công giảng dạy

}
