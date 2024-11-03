package com.oct.college_directory.controller;

import com.oct.college_directory.entity.Users;
import com.oct.college_directory.repository.UserRepo; // Ensure you import the correct UserRepo
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController {

    @Autowired
    private UserRepo userRepository;
    @PostMapping(value = "/login", consumes = "application/json")
    public ResponseEntity<?> login(@RequestBody Users loginUser) {
        Users user = userRepository.findByUsernameAndPasswordAndRole(
            loginUser.getUsername(), 
            loginUser.getPassword(), 
            loginUser.getRole()
        );

        if (user != null) {
            return ResponseEntity.ok(user); 
        } else {
            return ResponseEntity.status(401).body("Invalid credentials or role"); 
        }
    }
}
