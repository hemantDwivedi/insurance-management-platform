package com.insuremyteam.insurancemanagement.payload;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ClaimDAO {
    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private String contact;
}
