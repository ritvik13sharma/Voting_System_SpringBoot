package com.example.Voting_System.Repository;

import com.example.Voting_System.Models.SecuredUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecuredUserRepository extends JpaRepository<SecuredUser,Integer> {
    SecuredUser findByUsername(String name);
}
