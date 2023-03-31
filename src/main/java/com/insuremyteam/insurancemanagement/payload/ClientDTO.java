package com.insuremyteam.insurancemanagement.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ClientDTO {
    private Integer Id;
    @NotBlank(message = "name is mandatory")
    private String name;
    @NotNull(message = "Date of Birth should be blank")
    private LocalDate dateOfBirth;
    @NotBlank(message = "Address should not be blank")
    private String address;
    @NotBlank(message = "contact should not be blank")
    @Size(min = 10, max = 10, message = "contact should 10 digits")
    private String contact;


    private List<InsurancePolicyDTO> policyList;
}
