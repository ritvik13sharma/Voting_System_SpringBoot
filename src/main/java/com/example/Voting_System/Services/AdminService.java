package com.example.Voting_System.Services;

import com.example.Voting_System.Config.Constants;
import com.example.Voting_System.Models.Admin;
import com.example.Voting_System.Models.Candidate;
import com.example.Voting_System.Models.SecuredUser;
import com.example.Voting_System.Repository.AdminRepository;
import com.example.Voting_System.Repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    SecuredUserService securedUserService;
    @Autowired
    CandidateRepository candidateRepository;
    public void create(Admin admin){
        SecuredUser securedUser = admin.getSecuredUser();
        securedUser = securedUserService.save(securedUser, Constants.ADMIN_USER);

        admin.setSecuredUser(securedUser);
        adminRepository.save(admin);
    }

    public Admin find(int adminId){
        return adminRepository.findById(adminId).orElse(null);
    }

    public Candidate createCandidate(Candidate candidate)
    {
        return candidateRepository.save(candidate);
    }
}
