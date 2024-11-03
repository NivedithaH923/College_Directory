package com.oct.college_directory.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "title")
	    private String title;

	    @Column(name = "description")
	    private String description;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JsonBackReference
	    @JoinColumn(name = "department_id", referencedColumnName = "id")
	    private Department department;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JsonBackReference
	    @JoinColumn(name = "faculty_id", referencedColumnName = "user_id")
	    private FacultyProfile facultyProfile;
	    
	    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
	    @JsonIgnore
	    private Set<Enrollment> enrollments = new HashSet<>();
		public Course() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Course(Long id, String title, String description, Department department, FacultyProfile facultyProfile) {
			super();
			this.id = id;
			this.title = title;
			this.description = description;
			this.department = department;
			this.facultyProfile = facultyProfile;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}

		public FacultyProfile getFacultyProfile() {
			return facultyProfile;
		}

		public void setFacultyProfile(FacultyProfile facultyProfile) {
			this.facultyProfile = facultyProfile;
		}
		public Set<Enrollment> getEnrollments() {
	        return enrollments;
	    }

	    public void setEnrollments(Set<Enrollment> enrollments) {
	        this.enrollments = enrollments;
	    }
	    
}
