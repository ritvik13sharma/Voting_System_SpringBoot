package com.example.Voting_System.Dtos;

import com.example.Voting_System.Models.Candidate;
import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateCandidateRequest {

    @NotBlank
    private String name;
    private Candidate toCandidate()
    {
        return Candidate.builder()
                .name(this.name)
                .votes(0)
                .build();
    }
}
