package com.example.demo.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TuitionFee")
public class TuitionFee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private LocalDate registrationDate;

    private LocalDate collectionDate;

    private String note;

    private Boolean collectedMoney;

    private Boolean activate;
	
	@ManyToOne
    @JoinColumn(name = "student_id") // tên cột trong bảng
    @JsonBackReference
    private Student student;
	
	@ManyToOne
    @JoinColumn(name = "employee_id") // tên cột trong bảng
    @JsonBackReference
    private Employee employee;

	@ManyToOne
    @JoinColumn(name = "course_id") // tên cột trong bảng
    @JsonBackReference
    private Course course;
}
