package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "attendance")
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private LocalDate dateOfRecognition;
	
	@Size(min = 3, max = 200, message = "Note must be between 3 and 200 characters")
	private String note;
	
	@ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student; // trường này để tham chiếu đến Student

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee; // Tên thuộc tính là 'employee'


}
