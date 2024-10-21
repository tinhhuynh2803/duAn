package com.example.demo.model;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "classsession")
public class ClassSession {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Timeslot is required")
	private LocalTime timeSlot;
	
	@Size(min = 3, max = 200, message = "Note must be between 3 and 200 characters")
	private String note;
	
	@OneToMany(mappedBy = "classSession", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Course> courses;
}
