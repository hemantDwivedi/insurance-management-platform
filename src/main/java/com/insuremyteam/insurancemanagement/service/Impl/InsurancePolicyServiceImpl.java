package com.insuremyteam.insurancemanagement.service.Impl;

import com.insuremyteam.insurancemanagement.config.ModelMap;
import com.insuremyteam.insurancemanagement.exception.ResourceNotFoundException;
import com.insuremyteam.insurancemanagement.models.InsurancePolicy;
import com.insuremyteam.insurancemanagement.payload.InsurancePolicyDAO;
import com.insuremyteam.insurancemanagement.repository.InsurancePolicyRepository;
import com.insuremyteam.insurancemanagement.service.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyService {

    @Autowired
    private InsurancePolicyRepository insurancePolicyRepository;

    @Autowired
    private ModelMap modelMap;

    // create new insurance policy
    @Override
    public InsurancePolicyDAO createInsurancePolicy(InsurancePolicyDAO insurancePolicyDAO) {
        InsurancePolicy insurancePolicy = this.modelMap.modelMapper().map(insurancePolicyDAO, InsurancePolicy.class);
        InsurancePolicy savePolicy = this.insurancePolicyRepository.save(insurancePolicy);
        return this.modelMap.modelMapper().map(savePolicy, InsurancePolicyDAO.class);
    }


    // fetch all insurance policy
    @Override
    public List<InsurancePolicyDAO> getAllPolicy() {
        List<InsurancePolicy> insurancePolicyList = this.insurancePolicyRepository.findAll();
        return insurancePolicyList
                .stream()
                .map(
                        insurancePolicy -> this.modelMap.modelMapper().map(insurancePolicy, InsurancePolicyDAO.class)
                ).collect(Collectors.toList());
    }


    // update a insurance policy
    @Override
    public InsurancePolicyDAO updatePolicy(Integer policyId, InsurancePolicyDAO insurancePolicyDAO) {
        InsurancePolicy insurancePolicy = this.insurancePolicyRepository.findById(policyId).orElseThrow(
                () -> new ResourceNotFoundException("client not found with id: " + policyId)
        );
        insurancePolicy.setPolicyNumber(insurancePolicyDAO.getPolicyNumber());
        insurancePolicy.setPolicyType(insurancePolicyDAO.getPolicyType());
        insurancePolicy.setCoverageAmount(insurancePolicyDAO.getCoverageAmount());
        insurancePolicy.setPremium(insurancePolicyDAO.getPremium());
        insurancePolicy.setStartDate(insurancePolicyDAO.getStartDate());
        insurancePolicy.setEndDate(insurancePolicyDAO.getEndDate());
        this.insurancePolicyRepository.save(insurancePolicy);
        return this.modelMap.modelMapper().map(insurancePolicy, InsurancePolicyDAO.class);
    }


    // fetch a spcific insurance policy
    @Override
    public InsurancePolicyDAO getPolicyById(Integer policyId) {
        InsurancePolicy insurancePolicy = this.insurancePolicyRepository.findById(policyId)
                .orElseThrow(() -> new ResourceNotFoundException("client not found with id: " + policyId));
        return this.modelMap.modelMapper().map(insurancePolicy, InsurancePolicyDAO.class);
    }

    // delete a specific policy by id
    @Override
    public void deletePolicyById(Integer policyId) {
        InsurancePolicy insurancePolicy = this.insurancePolicyRepository.findById(policyId)
                .orElseThrow(() -> new ResourceNotFoundException("client not found with id: " + policyId));

        this.insurancePolicyRepository.delete(insurancePolicy);
    }
}
