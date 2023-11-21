package com.example.Voting_System.Repository;

import com.example.Voting_System.Models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
}
