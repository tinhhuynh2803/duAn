package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "TeachingAbility")
public class TeachingAbility {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonBackReference(value = "empTeach")
    private Employee employee; // Nhân viên đảm nhận môn học


    @ManyToOne
    @JoinColumn(name = "topics_id")
    @JsonBackReference(value = "teachTopic")
    private Topics topics; // Môn học

    // Mối quan hệ 1:N với TeachingAssignment
    @OneToMany(mappedBy = "teachingAbility", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeachingAssignment> teachingAssignments; // Danh sách phân công giảng dạy



}
