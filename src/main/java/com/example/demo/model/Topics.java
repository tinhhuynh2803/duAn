package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "Topics")
public class Topics {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	private String topicsCode;

	private String topicsName;

	private Integer theoryHours;

	private Integer practicalHours;

	private Boolean actived;
	private  double originalPrice;
	private double PromotionalPrice;

	
	@OneToMany(mappedBy = "topics", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore // Ngăn chặn việc serialize thuộc tính courses
	private List<Course> courses;
	
	// Mối quan hệ 1:N với SubjectAssignment
    @OneToMany(mappedBy = "topics", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
    private List<TeachingAbility> teachingAbilities; // Danh sách phân công môn học
}
