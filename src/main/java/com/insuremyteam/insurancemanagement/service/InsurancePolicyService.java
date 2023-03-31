package com.insuremyteam.insurancemanagement.service;

import com.insuremyteam.insurancemanagement.payload.InsurancePolicyDAO;

import java.util.List;

public interface InsurancePolicyService{
    InsurancePolicyDAO createInsurancePolicy(InsurancePolicyDAO insurancePolicyDAO);
    List<InsurancePolicyDAO> getAllPolicy();
    InsurancePolicyDAO updatePolicy(Integer policyId, InsurancePolicyDAO insurancePolicyDAO);
    InsurancePolicyDAO getPolicyById(Integer policyId);
    void deletePolicyById(Integer policyId);
}
