package com.example.Voting_System.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Voter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private Boolean hasAlreadyVoted;
    @CreationTimestamp
    private Date createdOn;
    @OneToOne
    @JsonIgnoreProperties("voter")
    @JoinColumn
    private SecuredUser securedUser;
}
