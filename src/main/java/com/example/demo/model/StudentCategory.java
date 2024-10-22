package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "studentcategory")
public class StudentCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String studentCategoryName;
	
	// Thiết lập mối quan hệ 1:n với Student
    @OneToMany(mappedBy = "studentCategory", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
    private List<Student> students; // Danh sách sinh viên thuộc danh mục này
}
