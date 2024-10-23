package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "image")
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String imageName;

	private String imageUrl;

    @OneToMany(mappedBy = "image", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Student> students;


    @OneToMany(mappedBy = "image", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Employee> employees;


}
