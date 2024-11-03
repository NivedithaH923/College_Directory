package com.oct.college_directory.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.oct.college_directory.entity.AdministratorProfile;
import com.oct.college_directory.service.AdministratorProfileService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/administratorprofile")
public class AdministratorProfileController {
    private final AdministratorProfileService administratorProfileService;

    public AdministratorProfileController(AdministratorProfileService administratorProfileService) {
        this.administratorProfileService = administratorProfileService;
    }

    @GetMapping
    public List<AdministratorProfile> findAllAdministratorProfile() {
        return administratorProfileService.findAllAdministratorProfile();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministratorProfile> findAdministratorProfile(@PathVariable("id") Long id) {
        return administratorProfileService.findById(id)
                .map(profile -> new ResponseEntity<>(profile, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<AdministratorProfile> saveAdministratorProfile(@RequestBody AdministratorProfile administratorProfile) {
        AdministratorProfile savedProfile = administratorProfileService.saveAdministratorProfile(administratorProfile);
        return new ResponseEntity<>(savedProfile, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdministratorProfile> updateAdministratorProfile(@PathVariable("id") Long id, @RequestBody AdministratorProfile administratorProfile) {
        administratorProfile.setUserId(id); 
        return new ResponseEntity<>(administratorProfileService.updateAdministratorProfile(administratorProfile), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministratorProfile(@PathVariable("id") Long id) {
        if (!administratorProfileService.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        administratorProfileService.deleteAdministratorProfile(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
