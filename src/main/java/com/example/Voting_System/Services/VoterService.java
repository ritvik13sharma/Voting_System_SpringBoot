package com.example.Voting_System.Services;

import com.example.Voting_System.Config.Constants;
import com.example.Voting_System.Models.Candidate;
import com.example.Voting_System.Models.SecuredUser;
import com.example.Voting_System.Models.Voter;
import com.example.Voting_System.Repository.CandidateRepository;
import com.example.Voting_System.Repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoterService {
    @Autowired
    VoterRepository voterRepository;
    @Autowired
    SecuredUserService userService;
    @Autowired
    CandidateRepository candidateRepository;

    public void create(Voter voter) {
        SecuredUser securedUser = voter.getSecuredUser();
        securedUser = userService.save(securedUser, Constants.VOTER_USER);

        voter.setSecuredUser(securedUser);

        voterRepository.save(voter);
    }
    public Voter find(int id) {
        return voterRepository.findById(id).orElse(null);
    }

    public Voter vote(int candidateId, int voterId) {
        Candidate candidate = candidateRepository.findById(candidateId).orElse(null);
        Voter voter = voterRepository.findById(voterId).orElse(null);

        if (voter.getHasAlreadyVoted() == false) {
            Integer votes = candidate.getVotes();  // Votes Increased
            candidate.setVotes(votes + 1);
            candidateRepository.save(candidate);

            voter.setHasAlreadyVoted(true);  // Now this voter can't vote again.
            voterRepository.save(voter);
        }

        return voterRepository.findById(voterId).orElse(null);
    }
}

