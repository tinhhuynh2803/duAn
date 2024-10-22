package com.example.demo.model;

import java.time.LocalDate;
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Full name is required")
    @Column(nullable = false)
    private String fullName; // Họ và tên

    @Column(nullable = false)
    private LocalDate dateOfBirth; // Ngày sinh

    @Column(nullable = false)
    private Boolean gender; // Giới tính (1: Nam, 0: Nữ)

    @Column(nullable = false, unique = true)
    private String nationalID; // Số chứng minh nhân dân

    @Email(message = "Email should be valid")
    @Column(nullable = false, unique = true)
    private String email; // Email

    @Column(nullable = false)
    private String phoneNumber; // Số điện thoại

    @Column(nullable = false)
    private Boolean activation; // Trạng thái kích hoạt (1: Kích hoạt, 0: Không kích hoạt)

    // Mối quan hệ n:1 với EmployeeType
    @ManyToOne
    @JoinColumn(name = "employee_type_id", nullable = false)
    @JsonBackReference
    private EmployeeType employeeType; // Kiểu nhân viên
    
    // Mối quan hệ n:1 với Major
    @ManyToOne
    @JoinColumn(name = "major_id", nullable = false)
    @JsonBackReference
    private Major major; // Chuyên ngành của nhân viên
    
    // Mối quan hệ 1:1 với Image
    @OneToOne
    @JoinColumn(name = "image_id", unique = true)
    private Image image; // Hình ảnh của nhân viên
    
    // Mối quan hệ 1:N với TeachingAssignment
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<TeachingAssignment> teachingAssignments; // Danh sách phân công giảng dạy

    // Thiết lập mối quan hệ với RegisterCourse
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<RegisterCourse> registerCourses;
    
    // Thêm mối quan hệ với Attendance
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Attendance> attendances; // Danh sách attendance của nhân viên
}
