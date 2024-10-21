package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
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
@Table(name = "subjectassignment")
public class SubjectAssignment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Thiết lập mối quan hệ N:1 với Employee
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee; // Nhân viên đảm nhận môn học
    
    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject; // Môn học
    
    // Mối quan hệ 1:N với TeachingAssignment
    @OneToMany(mappedBy = "subjectAssignment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeachingAssignment> teachingAssignments; // Danh sách phân công giảng dạy
    
    

}
