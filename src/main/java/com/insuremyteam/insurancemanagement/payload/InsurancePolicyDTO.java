package com.insuremyteam.insurancemanagement.payload;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class InsurancePolicyDTO {

    private Integer policyId;

    @NotNull(message = "Policy number should not be blank")
    private String policyNumber;

    @NotNull(message = "Policy type should not be blank")
    private String policyType;

    @NotNull(message = "Coverage amount should not be blank")
    private double coverageAmount;

    @NotNull(message = "Policy premium should not be blank")
    private String premium;

    @NotNull(message = "Policy start date should not be blank")
    private LocalDate startDate;

    @NotNull(message = "Policy end date should not be blank")
    private LocalDate endDate;
}
