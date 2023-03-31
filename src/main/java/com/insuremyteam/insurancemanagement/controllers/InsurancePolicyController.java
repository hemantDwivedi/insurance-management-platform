package com.insuremyteam.insurancemanagement.controllers;

import com.insuremyteam.insurancemanagement.payload.InsurancePolicyDAO;
import com.insuremyteam.insurancemanagement.service.InsurancePolicyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class InsurancePolicyController {

    @Autowired
    private InsurancePolicyService service;

    @PostMapping
    public ResponseEntity<InsurancePolicyDAO> createInsurance(@Valid @RequestBody InsurancePolicyDAO insurancePolicyDAO){
        return new ResponseEntity<>(this.service.createInsurancePolicy(insurancePolicyDAO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<InsurancePolicyDAO>> getAllInsurance(){
        return new ResponseEntity<>(this.service.getAllPolicy(), HttpStatus.FOUND);
    }

    @GetMapping("/{policyId}")
    public ResponseEntity<InsurancePolicyDAO> getPolicyById(@PathVariable Integer policyId){
        return new ResponseEntity<>(this.service.getPolicyById(policyId), HttpStatus.FOUND);
    }

    @PutMapping("/{policyId}")
    public ResponseEntity<InsurancePolicyDAO> updateInsurance(@PathVariable Integer policyId, @Valid @RequestBody InsurancePolicyDAO insurancePolicyDAO){
        return new ResponseEntity<>(this.service.updatePolicy(policyId, insurancePolicyDAO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{policyId}")
    public String deleteInsurance(@PathVariable Integer policyId){
        this.service.deletePolicyById(policyId);
        return "insurance policy deleted with Id: " + policyId;
    }
}
