package com.insuremyteam.insurancemanagement.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ClientDAO {
    @NotBlank(message = "name is mandatory")
    private String name;
    private LocalDate dateOfBirth;
    @NotBlank(message = "Address should not be blank")
    private String address;
    @NotBlank(message = "contact should not be blank")
    @Size(min = 10, max = 10, message = "contact should 10 digits")
    private String contact;
}
