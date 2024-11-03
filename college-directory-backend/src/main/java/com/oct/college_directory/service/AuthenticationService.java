//package com.oct.college_directory.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.oct.college_directory.entity.Users;
//import com.oct.college_directory.entity.Role;  // Import Role enum
//import com.oct.college_directory.repository.UserRepo;
//
//@Service
//public class AuthenticationService {
//
//    @Autowired
//    private UserRepo usersRepository;
//
//    // Modify the authenticate method to accept Role type for role
//    public Users authenticate(String username, String password, Role role) {
//        // Find the user by username and role
//        Users user = usersRepository.findByUsernameAndRole(username, role);
//
//        // Compare passwords directly as plain text (since we're not using encryption)
//        if (user != null && user.getPassword().equals(password)) {
//            return user;
//        }
//        return null; // If authentication fails
//    }
//}
