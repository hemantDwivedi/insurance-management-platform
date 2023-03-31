package com.insuremyteam.insurancemanagement.service;

import com.insuremyteam.insurancemanagement.payload.InsurancePolicyDTO;

import java.util.List;

public interface InsurancePolicyService{
    InsurancePolicyDTO createInsurancePolicy(InsurancePolicyDTO insurancePolicyDTO);
    List<InsurancePolicyDTO> getAllPolicy();
    InsurancePolicyDTO updatePolicy(Integer policyId, InsurancePolicyDTO insurancePolicyDTO);
    InsurancePolicyDTO getPolicyById(Integer policyId);
    void deletePolicyById(Integer policyId);
}
