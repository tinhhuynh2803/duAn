package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "image")
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String imageName;
	
	@Column(nullable = false)
	private String imageUrl;
	
	@OneToOne(mappedBy = "image", cascade = CascadeType.ALL, orphanRemoval = true)
    private Student student; // Sinh viên liên kết với hình ảnh
	
	// Thiết lập mối quan hệ 1:1 với Employee
    @OneToOne(mappedBy = "image", cascade = CascadeType.ALL, orphanRemoval = true)
    private Employee employee; // Nhân viên sở hữu hình ảnh này
    
    // Mối quan hệ 1:1 với Image
    @OneToOne
    @JoinColumn(name = "image_id", unique = true)
    private Image image; // Hình ảnh của nhân viên
}
