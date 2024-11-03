package com.oct.college_directory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oct.college_directory.entity.*;

public interface FacultyProfileRepo extends JpaRepository<FacultyProfile, Long> {

}
