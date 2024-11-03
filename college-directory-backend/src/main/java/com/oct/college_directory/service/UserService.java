package com.oct.college_directory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oct.college_directory.entity.*;
import com.oct.college_directory.repository.*;
@Service
public class UserService {
	private final UserRepo userRepo;
	
	public UserService(UserRepo userRepo) {
		
		this.userRepo = userRepo;
	}
	public List<Users> findAllUser() {
		return userRepo.findAll();
	}
	public Optional<Users> findById(Long id) {
		return userRepo.findById(id);
	}
	public Users saveUser(Users user) {
		return userRepo.save(user);
	}
	public Users updateUser(Users user) {
		return userRepo.save(user);
	}
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}

	public Users findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepo.findByUsername(username);
	}
}
