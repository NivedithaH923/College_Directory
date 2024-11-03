package com.oct.college_directory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.oct.college_directory.entity.StudentsProfile;
import com.oct.college_directory.service.StudentProfileService;

import java.util.List;

@RestController
@RequestMapping("/studentsprofile")
//@CrossOrigin(origins = "http://localhost:3000")
public class StudentProfileController {

    private final StudentProfileService studentProfileService;

    @Autowired
    public StudentProfileController(StudentProfileService studentProfileService) {
        this.studentProfileService = studentProfileService;
    }

    // Retrieve all student profiles
    @GetMapping
    public List<StudentsProfile> getAllStudentProfiles() {
        return studentProfileService.findAllStudentsProfile();
    }

    // Retrieve a specific student profile by user ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentsProfile> getStudentProfile(@PathVariable Long id) {
        StudentsProfile profile = studentProfileService.findByUserId(id);
        if (profile == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student profile not found");
        }
        return ResponseEntity.ok(profile);
    }

    // Create a new student profile
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentsProfile createStudentProfile(@RequestBody StudentsProfile studentsProfile) {
        return studentProfileService.saveStudentsProfile(studentsProfile);
    }

    // Update an existing student profile by user ID
    @PutMapping("/{id}")
    public StudentsProfile updateStudentProfile(@PathVariable("id") Long id, @RequestBody StudentsProfile studentProfile) {
        if (!studentProfileService.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student profile not found");
        }
        studentProfile.setUserId(id); // Ensure the ID is set for the update
        return studentProfileService.updateStudentsProfile(studentProfile);
    }

    // Delete a student profile by user ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudentProfile(@PathVariable("id") Long id) {
        if (!studentProfileService.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student profile not found");
        }
        studentProfileService.deleteStudentsProfile(id);
    }
}
