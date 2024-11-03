package com.oct.college_directory.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oct.college_directory.entity.FacultyProfile;
import com.oct.college_directory.entity.Users;
import com.oct.college_directory.service.FacultyProfileService;
import com.oct.college_directory.service.UserService; // Assume you have this service to access Users

@RestController
@RequestMapping("/facultyprofile")
public class FacultyProfileController {
    private final FacultyProfileService facultyProfileService;
    private final UserService usersService; // Service to fetch Users

    // Constructor injection of the FacultyProfileService and UsersService
    public FacultyProfileController(FacultyProfileService facultyProfileService, UserService usersService) {
        this.facultyProfileService = facultyProfileService;
        this.usersService = usersService;
    }

    // Retrieve all faculty profiles
    @GetMapping
    public List<FacultyProfile> findAllFacultyProfile() {
        return facultyProfileService.findAllFacultyProfile();
    }

    // Retrieve a specific faculty profile by ID
    @GetMapping("/{id}")
    public Optional<FacultyProfile> findFacultyProfile(@PathVariable("id") Long id) {
        return facultyProfileService.findById(id);
    }

    // Retrieve the current faculty profile
    @GetMapping("/current")
    public ResponseEntity<FacultyProfile> getCurrentFacultyProfile(Principal principal) {
        // Extract user ID from the principal
        Long userId = getUserIdFromPrincipal(principal);
        
        // Find the faculty profile by user ID
        Optional<FacultyProfile> facultyProfile = facultyProfileService.findById(userId);

        return facultyProfile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new faculty profile
    @PostMapping
    public FacultyProfile saveFacultyProfile(@RequestBody FacultyProfile facultyProfile) {
        return facultyProfileService.saveFacultyProfile(facultyProfile);
    }

    // Update an existing faculty profile by ID
    @PutMapping("/{id}")
    public FacultyProfile updateFacultyProfile(@PathVariable("id") Long id, @RequestBody FacultyProfile facultyProfile) {
        facultyProfile.setUser_id(id); // Ensure the ID is set for the update
        return facultyProfileService.updateFacultyProfile(facultyProfile);
    }

    // Delete a faculty profile by ID
    @DeleteMapping("/{id}")
    public void deleteFacultyProfile(@PathVariable("id") Long id) {
        facultyProfileService.deleteFacultyProfile(id);
    }

    // Method to extract user ID from Principal
    private Long getUserIdFromPrincipal(Principal principal) {
        if (principal != null) {
            // Assuming the principal is an instance of Spring Security's User
            String username = principal.getName(); // Get the username from the principal
            Users user = usersService.findByUsername(username); // Fetch the user by username
            if (user != null) {
                return user.getId(); // Return the user ID
            }
        }
        throw new IllegalArgumentException("No user found in the session");
    }
}
