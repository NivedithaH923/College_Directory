package com.oct.college_directory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oct.college_directory.entity.AdministratorProfile;
import com.oct.college_directory.repository.AdministratorProfileRepo;
import java.util.List;
import java.util.Optional;

@Service
public class AdministratorProfileService {
    private final AdministratorProfileRepo administratorProfileRepo;

    @Autowired
    public AdministratorProfileService(AdministratorProfileRepo administratorProfileRepo) {
        this.administratorProfileRepo = administratorProfileRepo;
    }

    public List<AdministratorProfile> findAllAdministratorProfile() {
        return administratorProfileRepo.findAll();
    }

    public Optional<AdministratorProfile> findById(Long id) {
        return administratorProfileRepo.findById(id);
    }

    public AdministratorProfile saveAdministratorProfile(AdministratorProfile administratorProfile) {
        return administratorProfileRepo.save(administratorProfile);
    }

    public AdministratorProfile updateAdministratorProfile(AdministratorProfile administratorProfile) {
        if (!administratorProfileRepo.existsById(administratorProfile.getUserId())) {
            throw new RuntimeException("Administrator profile not found with id: " + administratorProfile.getUserId());
        }
        return administratorProfileRepo.save(administratorProfile);
    }

    public void deleteAdministratorProfile(Long id) {
        administratorProfileRepo.deleteById(id);
    }
}
