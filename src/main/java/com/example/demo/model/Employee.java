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

    private String fullName; // Họ và tên

    private LocalDate dateOfBirth; // Ngày sinh

    private Boolean gender; // Giới tính (1: Nam, 0: Nữ)

    private String nationalID; // Số chứng minh nhân dân

    private String email; // Email

    private String phoneNumber; // Số điện thoại

    private Boolean activation; // Trạng thái kích hoạt (1: Kích hoạt, 0: Không kích hoạt)

    private String address;

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

    // Mối quan hệ n:1 với Image
    @ManyToOne
    @JoinColumn(name = "image_id", nullable = false)
    @JsonBackReference
    private Image image; // hình ảnh của nhân viên

    @ManyToOne
    @JoinColumn(name = "degreeLevel_id", nullable = false)
    @JsonBackReference
    private DegreeLevel degreeLevel; // Trình độ của nhân viên


    // Mối quan hệ 1:N với TeachingAssignment
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<TeachingAssignment> teachingAssignments; // Danh sách phân công giảng dạy

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true) // Đúng
    @JsonManagedReference
    private List<TuitionFee> tuitionFees;


    // Mối quan hệ 1:N với TeachingAbility
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<TeachingAbility> teachingAbilities; // Danh sách khả năng giảng dạy


}
