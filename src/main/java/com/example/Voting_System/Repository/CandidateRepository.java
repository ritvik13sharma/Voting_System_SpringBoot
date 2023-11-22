package com.example.Voting_System.Repository;

import com.example.Voting_System.Models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate,Integer> {
    Candidate findByName(String name);
}
