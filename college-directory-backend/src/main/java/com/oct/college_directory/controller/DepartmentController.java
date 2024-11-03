package com.oct.college_directory.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oct.college_directory.entity.Department;
import com.oct.college_directory.service.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	private final DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		
		this.departmentService = departmentService;
	}
	@GetMapping
	public List<Department> findAllDepartment(){
		return departmentService.findAllDepartment();
		
	}
	@GetMapping("/{id}")
	public Optional<Department> findDepartment(@PathVariable("id") Long id){
		return departmentService.findById(id);
	}
	
	@PostMapping
	public Department saveDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}
	@PutMapping
	public Department updateDepartment(@RequestBody Department department) {
		return departmentService.updateDepartment(department);
	}
	@DeleteMapping
	public void deleteDepartment(@PathVariable("id") Long id) {
		 departmentService.deleteDepartment(id);
		
	}
	
}
