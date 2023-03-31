package com.insuremyteam.insurancemanagement.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "claim")
@Getter
@Setter
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer claimId;
    private String claimNumber;
    private String description;
    private LocalDate claimDate;
    private String claimStatus;
}
