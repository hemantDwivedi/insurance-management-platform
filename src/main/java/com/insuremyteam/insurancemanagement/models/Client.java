package com.insuremyteam.insurancemanagement.models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "client")
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private String contact;

    @OneToMany(mappedBy = "client")
    private List<InsurancePolicy> policy;
}
