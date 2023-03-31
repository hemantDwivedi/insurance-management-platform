package com.insuremyteam.insurancemanagement.controllers;

import com.insuremyteam.insurancemanagement.payload.APIResponse;
import com.insuremyteam.insurancemanagement.payload.InsurancePolicyDTO;
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

    @PostMapping("/client/{clientId}/claim/{claimId}")
    public ResponseEntity<InsurancePolicyDTO> createInsurance(@Valid @RequestBody InsurancePolicyDTO insurancePolicyDTO,
                                                              @PathVariable Integer clientId,
                                                              @PathVariable Integer claimId){
        return new ResponseEntity<>(this.service.createInsurancePolicy(insurancePolicyDTO, clientId, claimId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<InsurancePolicyDTO>> getAllInsurance(){
        return new ResponseEntity<>(this.service.getAllPolicy(), HttpStatus.FOUND);
    }

    @GetMapping("/{policyId}")
    public ResponseEntity<InsurancePolicyDTO> getPolicyById(@PathVariable Integer policyId){
        return new ResponseEntity<>(this.service.getPolicyById(policyId), HttpStatus.FOUND);
    }

    @PutMapping("/{policyId}")
    public ResponseEntity<InsurancePolicyDTO> updateInsurance(@PathVariable Integer policyId, @Valid @RequestBody InsurancePolicyDTO insurancePolicyDTO){
        return new ResponseEntity<>(this.service.updatePolicy(policyId, insurancePolicyDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{policyId}")
    public ResponseEntity<APIResponse> deleteInsurance(@PathVariable Integer policyId){
        this.service.deletePolicyById(policyId);
        return new ResponseEntity<>(new APIResponse("claim deleted with id: " + policyId), HttpStatus.BAD_REQUEST);
    }
}
