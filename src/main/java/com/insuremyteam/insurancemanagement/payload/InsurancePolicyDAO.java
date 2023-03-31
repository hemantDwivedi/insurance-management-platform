package com.insuremyteam.insurancemanagement.payload;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class InsurancePolicyDAO {
    private String policyNumber;

    private String policyType;

    private double coverageAmount;

    private String premium;

    private LocalDate startDate;

    private LocalDate endDate;
}
