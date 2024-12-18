	package com.example.demo.model;

	import java.time.LocalDate;
	import java.util.List;
	import java.util.Set;

	import com.example.demo.repository.TopicsRepository;
	import com.example.demo.service.ISessionService;
	import com.example.demo.service.impl.SessionServiceImpl;
	import com.example.demo.service.impl.TopicsServiceImpl;
	import com.fasterxml.jackson.annotation.JsonBackReference;
	import com.fasterxml.jackson.annotation.JsonIdentityInfo;
	import com.fasterxml.jackson.annotation.JsonManagedReference;
	import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
	@Table(name = "course")
	public class Course {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		private String courseCode;

		private String courseName;

		private LocalDate startDate;

		private LocalDate endDate;

		private Integer totalStudent;

		private Boolean activate;

		public Long getSessionId() {
			return session != null ? session.getId() : null;
		}

		public Long getTopicsId() {
			return topics != null ? topics.getId() : null;
		}

		@ManyToOne
		@JoinColumn(name = "session_id")// This prevents infinite recursion
		@JsonBackReference(value = "sessionCourse") // Thay đổi thành JsonManagedReference
		private Session session;

		@ManyToOne
		@JoinColumn(name = "topics_id") // Khóa ngoại liên kết đến Topic
		@JsonBackReference(value = "topicCourse") // Thay đổi thành JsonManagedReference
		private Topics topics;

		@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true) // Mối quan hệ n:1
		@JsonManagedReference(value = "scheduleCourse")
		private List<ClassSchedule> classSchedules;

		// Mối quan hệ 1:N với TeachingAssignment
		@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
		@JsonManagedReference(value = "teachCourse")
		private List<TeachingAssignment> teachingAssignments; // Danh sách phân công giảng dạy

		// Thiết lập mối quan hệ với TuitionFee
		@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
		@JsonManagedReference(value = "tuitionCourse")
		private Set<TuitionFee> tuitionFees;
		// Add method to get session name
		public String getSessionName() {
			return session != null ? session.getSessionName() : null; // Assuming 'getName()' exists in Session
		}

		// Add method to get topics name
		public String getTopicsName() {
			return topics != null ? topics.getTopicsName() : null; // Assuming 'getName()' exists in Topics
		}
	}
