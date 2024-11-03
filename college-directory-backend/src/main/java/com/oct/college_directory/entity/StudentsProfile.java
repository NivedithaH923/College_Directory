package com.oct.college_directory.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "studentsprofile")
public class StudentsProfile {
    @Id
    private Long userId; // This will also serve as the foreign key

    @Column(name = "photo")
    private String photo;

    @Column(name = "year")
    private String year;
    @JsonBackReference
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Enrollment> enrollments = new HashSet<>();
    @JsonBackReference
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id", referencedColumnName = "id") // Links to 'id' in Users table
    private Users user;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id") // Links to 'id' in Department table
    private Department department;

    public StudentsProfile() {}

    public StudentsProfile(String photo, String year, Users user, Department department) {
        this.photo = photo;
        this.year = year;
        this.user = user;
        this.department = department;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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
}
