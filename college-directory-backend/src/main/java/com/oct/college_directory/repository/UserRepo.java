package com.oct.college_directory.repository;

import com.oct.college_directory.entity.Role;
import com.oct.college_directory.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Long> {
    // Custom query method to find user by username, password, and role
	Users findByUsernameAndPasswordAndRole(String username, String password, Role role);
	//Users findByUsernameAndPasswordAndRole(String username, String password, String role);

	Users findByUsername(String username);
}
