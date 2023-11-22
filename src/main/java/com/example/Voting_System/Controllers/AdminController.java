package com.example.Voting_System.Controllers;

import com.example.Voting_System.Dtos.CreateAdminRequest;
import com.example.Voting_System.Dtos.CreateCandidateRequest;
import com.example.Voting_System.Models.Admin;
import com.example.Voting_System.Models.Candidate;
import com.example.Voting_System.Repository.CandidateRepository;
import com.example.Voting_System.Services.AdminService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;
    @Autowired
    CandidateRepository candidateRepository;

    @PostMapping("/admin/create")
    public void createAdmin(@RequestBody @Valid CreateAdminRequest createAdminRequest){
        adminService.create(createAdminRequest.toAdmin());
    }

    @GetMapping("/candidates")
    public List<Candidate> allCandidates()
    {
        return candidateRepository.findAll();
    }

    @PostMapping("/candidate/create")
    public void create(@RequestBody @Valid CreateCandidateRequest createCandidateRequest)
    {
        adminService.createCandidate(createCandidateRequest.toCandidate());
    }
}
