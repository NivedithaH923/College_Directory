package com.oct.college_directory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oct.college_directory.entity.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {
    
}

