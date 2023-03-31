package com.insuremyteam.insurancemanagement.models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "policy")
@Getter
@Setter
public class InsurancePolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer policyId;

    private String policyNumber;

    private String policyType;

    private double coverageAmount;

    private String premium;

    private LocalDate startDate;

    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "claim_id")
    private Claim claim;
}
