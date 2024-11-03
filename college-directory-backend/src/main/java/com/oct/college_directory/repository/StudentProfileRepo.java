package com.oct.college_directory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oct.college_directory.entity.StudentsProfile;

public interface StudentProfileRepo extends JpaRepository<StudentsProfile, Long>  {
    StudentsProfile findByUserId(Long userId);
}
