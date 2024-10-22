package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String courseCode;

	private String courseName;

	private LocalDate startDate;

	private LocalDate endDate;
	
	@ManyToOne
    @JoinColumn(name = "class_session_id") // Khóa ngoại liên kết đến ClassSession
    private ClassSession classSession;
	
	@ManyToOne
    @JoinColumn(name = "subject_id") // Khóa ngoại liên kết đến Subject
	@JsonBackReference
    private Subject subject;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true) // Mối quan hệ 1:n
	@JsonManagedReference
    private List<Tuition> tuitionList; // Danh sách học phí liên kết với Course

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true) // Mối quan hệ n:1
	@JsonManagedReference
    private List<Schedule> schedules;
	
	// Mối quan hệ 1:N với TeachingAssignment
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
    private List<TeachingAssignment> teachingAssignments; // Danh sách phân công giảng dạy

    // Thiết lập mối quan hệ với RegisterCourse
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
    private Set<RegisterCourse> registerCourses;
}
