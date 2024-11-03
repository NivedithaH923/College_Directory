package com.oct.college_directory.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name="facultyprofile")
public class FacultyProfile {
	@Id
    private Long user_id; // Will be mapped from Users entity due to @MapsId

    @Column(name = "photo")
    private String photo;

    @Column(name = "officehours")
    private String officehours;
    
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id", referencedColumnName = "id") // Links to 'id' in Users table
    @JsonBackReference
    private Users user;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id") // Links to 'id' in Department table
    private Department department;
    
    @OneToMany(mappedBy = "facultyProfile", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Course> courses;
	public FacultyProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FacultyProfile(Long user_id, String photo, String officehours, Users user, Department department) {
		super();
		this.user_id = user_id;
		this.photo = photo;
		this.officehours = officehours;
		this.user = user;
		this.department = department;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getOfficehours() {
		return officehours;
	}

	public void setOfficehours(String officehours) {
		this.officehours = officehours;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    
}
