package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subject")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	private String subjectCode;

	private String subjectName;

	private Integer theoryHours;

	private Integer practicalHours;

	private Boolean isActive;
	
	@ManyToOne
    @JoinColumn(name = "schedule_id")
	@JsonIgnore // Ngăn không cho serialize Subject khi serialize Course
	private Schedule schedule;
	
	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Course> courses;
	
	// Mối quan hệ 1:N với SubjectAssignment
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
    private List<SubjectAssignment> subjectAssignments; // Danh sách phân công môn học
}
