package com.oct.college_directory.repository;

import org.springframework.stereotype.Repository;
import com.oct.college_directory.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

}
