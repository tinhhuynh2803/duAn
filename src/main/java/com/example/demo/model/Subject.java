package com.example.demo.model;

import java.util.List;

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
	
	@Column(nullable = false)
	private String subjectCode;
	
	@Column(nullable = false)
	private String subjectName;
	
	@Column(nullable = false)
	private Integer theoryHours;
	
	@Column(nullable = false)
	private Integer practicalHours;
	
	@Column(nullable = false)
	private Boolean isActive;
	
	@ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;
	
	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Course> courses;
	
	// Mối quan hệ 1:N với SubjectAssignment
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubjectAssignment> subjectAssignments; // Danh sách phân công môn học
}
