package com.example.Voting_System.Services;

import com.example.Voting_System.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    SecuredUserService securedUserService;
}
