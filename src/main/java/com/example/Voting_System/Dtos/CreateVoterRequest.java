package com.example.Voting_System.Dtos;

import com.example.Voting_System.Models.SecuredUser;
import com.example.Voting_System.Models.Voter;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateVoterRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public Voter toVoter()
    {
        return Voter.builder()
                .name(this.name)
                .hasAlreadyVoted(false)
                .securedUser(SecuredUser.builder()
                        .username(this.username)
                        .password(this.password)
                        .build())
                .build();
    }


}
