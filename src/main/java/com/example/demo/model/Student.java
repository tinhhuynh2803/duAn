package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String fullName;
	
	@Column(nullable = false)
    private LocalDate dateOfBirth; // Ngày sinh

    @Column(nullable = false)
    private String address; // Địa chỉ

    @Column(nullable = false)
    private String phoneNumber; // Số điện thoại

    @Column(nullable = false)
    private Boolean gender; // Giới tính (1: Nam, 0: Nữ)

    @Column(nullable = false, unique = true)
    private String nationalID; // Số chứng minh nhân dân

    @Email(message = "Email should be valid")
    @Column(nullable = false, unique = true)
    private String email; // Email

    @Column(nullable = false)
    private Boolean activate; // Trạng thái kích hoạt (1: Kích hoạt, 0: Không kích hoạt)

    @Column(nullable = false, unique = true)
    private String studentCode; // Mã sinh viên
    
    @ManyToOne
    @JoinColumn(name = "degreelevel_id", nullable = false)
    private DegreeLevel degreeLevel; // Cấp độ học
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id") // Tên cột trong bảng Student để lưu trữ ID hình ảnh
    private Image image; // Hình ảnh của sinh viên
    
    // Thiết lập mối quan hệ n:1 với CategoryStudent
    @ManyToOne
    @JoinColumn(name = "studentcategory_id", nullable = false) // Tên cột trong bảng Student để lưu trữ ID danh mục
    private StudentCategory studentCategory; // Danh mục sinh viên
    
    // Thiết lập mối quan hệ với RegisterCourse
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RegisterCourse> registerCourses;
    
    // Thêm mối quan hệ với Attendance
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Attendance> attendances; // Danh sách attendance của sinh viên
}