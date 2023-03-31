package com.insuremyteam.insurancemanagement.repository;

import com.insuremyteam.insurancemanagement.models.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Integer> {
}
