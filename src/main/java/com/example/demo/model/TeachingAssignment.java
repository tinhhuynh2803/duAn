package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

	private Boolean activate;
	
	// Mối quan hệ N:1 với Employee
    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonBackReference
    private Employee employee; // Nhân viên đảm nhận phân công giảng dạy

    // Mối quan hệ N:1 với Course
    @ManyToOne
    @JoinColumn(name = "course_id") // Khóa ngoại liên kết đến Course
    @JsonBackReference
    private Course course; // Khóa học được phân công giảng dạy
    
    // Mối quan hệ N:1 với SubjectAssignment
    @ManyToOne
    @JoinColumn(name = "subjectassignment_id") // Khóa ngoại liên kết đến SubjectAssignment
    @JsonBackReference
    private SubjectAssignment subjectAssignment; // Môn học được phân công giảng dạy

}
