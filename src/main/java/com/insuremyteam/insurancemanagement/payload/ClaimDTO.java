package com.insuremyteam.insurancemanagement.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ClaimDTO {

    private Integer claimId;

    @NotBlank(message = "claim number should not be blank")
    private String claimNumber;

    @NotBlank(message = "description should not be blank")
    private String description;

    @NotNull(message = "claim date should not be blank")
    private LocalDate claimDate;

    @NotBlank(message = "claim status should not be blank")
    private String claimStatus;
}
