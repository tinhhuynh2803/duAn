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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "classroom")
public class ClassRoom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Name cannot be empty")  // Name không được để trống
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")  // Ràng buộc độ dài
    @Pattern(regexp = "^[A-Za-z0-9 ]+$", message = "Name can only contain alphanumeric characters and spaces")  // Ràng buộc ký tự
	private String roomName;
	
	@Size(min = 3, max = 200, message = "Note must be between 3 and 200 characters")
	private String note;
	
	@OneToMany(mappedBy = "classRoom", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Schedule> schedules;
}
