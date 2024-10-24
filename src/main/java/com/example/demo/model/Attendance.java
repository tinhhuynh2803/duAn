package com.example.demo.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

	private LocalDate dateOfRecognition;

	private String note;
	
	@ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
	@JsonBackReference(value = "attendStudent")
	private Student student; // trường này để tham chiếu đến Student


	@ManyToOne
	@JoinColumn(name = "classSchedule_id", nullable = false)
	@JsonBackReference(value = "attendClass")
	private ClassSchedule classSchedule; // trường này để tham chiếu đến ClassSchedule

}
