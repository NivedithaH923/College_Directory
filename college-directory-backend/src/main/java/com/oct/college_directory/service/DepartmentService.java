package com.oct.college_directory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oct.college_directory.entity.*;
import com.oct.college_directory.repository.*;
@Service
public class DepartmentService {
	private final DepartmentRepo departmentRepo;
	
	public DepartmentService(DepartmentRepo departmentRepo) {
		
		this.departmentRepo = departmentRepo;
	}
	public List<Department> findAllDepartment() {
		return departmentRepo.findAll();
	}
	public Optional<Department> findById(Long id) {
		return departmentRepo.findById(id);
	}
	public Department saveDepartment(Department department) {
		return departmentRepo.save(department);
	}
	public Department updateDepartment(Department department) {
		return departmentRepo.save(department);
	}
	public void deleteDepartment(Long id) {
		departmentRepo.deleteById(id);
	}
}



//package com.oct.college_directory.service;
//
//import java.util.List;
//
//import com.oct.college_directory.entity.*;
//
//public interface DepartmentService {
//	List<Department> findAllDepartment();
//	Department findById(Long id);
//	Department saveDepartment(Department department);
//	Department updateDepartment(Department department);
//	void deleteDepartment(Long id);
//}
