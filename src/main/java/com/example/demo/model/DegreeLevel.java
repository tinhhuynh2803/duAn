package com.example.demo.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "degreelevel")
public class DegreeLevel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String qualificationName;
	
	@Size(min = 3, max = 200, message = "Note must be between 3 and 200 characters")
	private String note;
	
	@OneToMany(mappedBy = "degreeLevel", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Student> students; // Danh sách sinh viên thuộc cấp độ này
}
