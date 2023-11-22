package com.example.Voting_System;

import com.example.Voting_System.Dtos.CreateAdminRequest;
import com.example.Voting_System.Models.Admin;
import com.example.Voting_System.Models.SecuredUser;
import com.example.Voting_System.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VotingSystemApplication implements CommandLineRunner {

	@Autowired
	AdminService adminService;

	public static void main(String[] args) {
		SpringApplication.run(VotingSystemApplication.class, args);
	}

	// For creating the First Admin myself.
	@Override
	public void run(String... args) throws Exception {
		Admin admin = Admin.builder()
			.name("Ritvik")
			.securedUser(
					SecuredUser.builder()
    							.username("ritvik")
     							.password("ritvik123")
    							.build()
    				).build();

		adminService.create(admin);
	}
}

