package com.example.Voting_System.Controllers;

import com.example.Voting_System.Dtos.CreateVoterRequest;
import com.example.Voting_System.Models.SecuredUser;
import com.example.Voting_System.Models.Voter;
import com.example.Voting_System.Services.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import java.util.Arrays;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.example.Voting_System.Config.Constants;

import javax.validation.Valid;

@RestController
public class VoterController {
    @Autowired
    VoterService voterService;

    @PostMapping("/voter/create") // kind of a sign-up API
    public void createVoter(@RequestBody @Valid CreateVoterRequest voterRequest){
        voterService.create(voterRequest.toVoter());
    }

    @GetMapping("/voter-by-id/{id}")
    public Voter findVoterById(@PathVariable("id") int voterId) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecuredUser securedUser = (SecuredUser) authentication.getPrincipal();

        for(GrantedAuthority grantedAuthority: securedUser.getAuthorities()){
            String[] authorities = grantedAuthority.getAuthority().split(Constants.DELIMITER);
            boolean isCalledByAdmin = Arrays.stream(authorities).anyMatch(x -> Constants.VOTER_INFO_AUTHORITY.equals(x));
            if (isCalledByAdmin) {
                return voterService.find(voterId);
            }

        }
        throw new Exception("You require Administrative Rights for this");
    }

    @GetMapping("/voter")
    public Voter findVoter(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecuredUser user = (SecuredUser) authentication.getPrincipal();
        int voterId = user.getVoter().getId();

        return voterService.find(voterId);
    }

    @PostMapping("/vote/candidate/{id1}")
    public Voter vote(@PathVariable("id1") int candidateId) throws Exception
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecuredUser user = (SecuredUser) authentication.getPrincipal();
        int voterId = user.getVoter().getId();

        return voterService.vote(candidateId,voterId);
    }
}
