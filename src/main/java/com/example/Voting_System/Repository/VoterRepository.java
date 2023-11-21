package com.example.Voting_System.Repository;

import com.example.Voting_System.Models.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoterRepository extends JpaRepository<Voter,Integer> {
}
