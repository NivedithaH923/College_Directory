package com.oct.college_directory.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="administratorprofile")
public class AdministratorProfile {

    @Id
    private Long userId; 

    @Column(name = "photo")
    private String photo;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference
    private Users user; 

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    @JsonBackReference 
    private Department department;

    public AdministratorProfile() {}

    public AdministratorProfile(Long userId, String photo, Users user, Department department) {
        this.userId = userId;
        this.photo = photo;
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
