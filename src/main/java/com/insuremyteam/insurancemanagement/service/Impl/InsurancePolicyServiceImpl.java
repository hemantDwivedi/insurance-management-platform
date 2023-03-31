package com.insuremyteam.insurancemanagement.service.Impl;

import com.insuremyteam.insurancemanagement.config.ModelMap;
import com.insuremyteam.insurancemanagement.exception.ResourceNotFoundException;
import com.insuremyteam.insurancemanagement.models.Claim;
import com.insuremyteam.insurancemanagement.models.Client;
import com.insuremyteam.insurancemanagement.models.InsurancePolicy;
import com.insuremyteam.insurancemanagement.payload.InsurancePolicyDTO;
import com.insuremyteam.insurancemanagement.repository.ClaimRepository;
import com.insuremyteam.insurancemanagement.repository.ClientRepository;
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
    private ClientRepository clientRepository;

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private ModelMap modelMap;

    // create new insurance policy
    @Override
    public InsurancePolicyDTO createInsurancePolicy(InsurancePolicyDTO insurancePolicyDTO,
                                                    Integer clientId,
                                                    Integer claimId) {
        InsurancePolicy insurancePolicy = this.modelMap.modelMapper().map(insurancePolicyDTO, InsurancePolicy.class);
        Client client = this.clientRepository.findById(clientId).orElseThrow(
                () -> new ResourceNotFoundException("client not found with id: " + clientId)
        );
        Claim claim = this.claimRepository.findById(claimId).orElseThrow(() -> new ResourceNotFoundException("claim not found with id: " + claimId));
        insurancePolicy.setClient(client);
        insurancePolicy.setClaim(claim);
        InsurancePolicy savePolicy = this.insurancePolicyRepository.save(insurancePolicy);
        return this.modelMap.modelMapper().map(savePolicy, InsurancePolicyDTO.class);
    }


    // fetch all insurance policy
    @Override
    public List<InsurancePolicyDTO> getAllPolicy() {
        List<InsurancePolicy> insurancePolicyList = this.insurancePolicyRepository.findAll();
        return insurancePolicyList
                .stream()
                .map(
                        insurancePolicy -> this.modelMap.modelMapper().map(insurancePolicy, InsurancePolicyDTO.class)
                ).collect(Collectors.toList());
    }


    // update a insurance policy
    @Override
    public InsurancePolicyDTO updatePolicy(Integer policyId, InsurancePolicyDTO insurancePolicyDTO) {
        InsurancePolicy insurancePolicy = this.insurancePolicyRepository.findById(policyId).orElseThrow(
                () -> new ResourceNotFoundException("policy not found with id: " + policyId)
        );
        insurancePolicy.setPolicyNumber(insurancePolicyDTO.getPolicyNumber());
        insurancePolicy.setPolicyType(insurancePolicyDTO.getPolicyType());
        insurancePolicy.setCoverageAmount(insurancePolicyDTO.getCoverageAmount());
        insurancePolicy.setPremium(insurancePolicyDTO.getPremium());
        insurancePolicy.setStartDate(insurancePolicyDTO.getStartDate());
        insurancePolicy.setEndDate(insurancePolicyDTO.getEndDate());
        this.insurancePolicyRepository.save(insurancePolicy);
        return this.modelMap.modelMapper().map(insurancePolicy, InsurancePolicyDTO.class);
    }


    // fetch a spcific insurance policy
    @Override
    public InsurancePolicyDTO getPolicyById(Integer policyId) {
        InsurancePolicy insurancePolicy = this.insurancePolicyRepository.findById(policyId)
                .orElseThrow(() -> new ResourceNotFoundException("policy not found with id: " + policyId));
        return this.modelMap.modelMapper().map(insurancePolicy, InsurancePolicyDTO.class);
    }

    // delete a specific policy by id
    @Override
    public void deletePolicyById(Integer policyId) {
        InsurancePolicy insurancePolicy = this.insurancePolicyRepository.findById(policyId)
                .orElseThrow(() -> new ResourceNotFoundException("policy not found with id: " + policyId));

        this.insurancePolicyRepository.delete(insurancePolicy);
    }
}
