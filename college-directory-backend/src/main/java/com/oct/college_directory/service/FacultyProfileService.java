package com.oct.college_directory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oct.college_directory.entity.*;
import com.oct.college_directory.repository.*;
@Service
public class FacultyProfileService {
	private final FacultyProfileRepo facultyProfileRepo;

    public FacultyProfileService(FacultyProfileRepo facultyProfileRepo) {
        this.facultyProfileRepo = facultyProfileRepo;
    }

    public List<FacultyProfile> findAllFacultyProfile() {
        return facultyProfileRepo.findAll();
    }

    public Optional<FacultyProfile> findById(Long id) {
        return facultyProfileRepo.findById(id);
    }

    public FacultyProfile saveFacultyProfile(FacultyProfile facultyProfile) {
        return facultyProfileRepo.save(facultyProfile);
    }

    public FacultyProfile updateFacultyProfile(FacultyProfile facultyProfile) {
        // Ensure the profile has a userId set
        if (!facultyProfileRepo.existsById(facultyProfile.getUser_id())) {
            throw new RuntimeException("Faculty profile not found with id: " + facultyProfile.getUser_id());
        }
        return facultyProfileRepo.save(facultyProfile);
    }

    public void deleteFacultyProfile(Long id) {
    	facultyProfileRepo.deleteById(id);
    }

	
}
