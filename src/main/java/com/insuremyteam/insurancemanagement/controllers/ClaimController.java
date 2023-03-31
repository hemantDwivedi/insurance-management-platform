package com.insuremyteam.insurancemanagement.controllers;

import com.insuremyteam.insurancemanagement.payload.APIResponse;
import com.insuremyteam.insurancemanagement.payload.ClaimDTO;
import com.insuremyteam.insurancemanagement.service.ClaimService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {
    @Autowired
    private ClaimService service;

    // create claim
    @PostMapping
    public ResponseEntity<ClaimDTO> createClaim(@Valid @RequestBody ClaimDTO claimDTO){
        return new ResponseEntity<>(this.service.createClaim(claimDTO), HttpStatus.OK);
    }

    // fetch all claims
    @GetMapping
    public ResponseEntity<List<ClaimDTO>> getAllClaim(){
        return new ResponseEntity<>(this.service.getAllClaim(), HttpStatus.FOUND);
    }

    // fetch a specific claim by id
    @GetMapping("/{claimId}")
    public ResponseEntity<ClaimDTO> getClaimById(@PathVariable Integer claimId){
        return new ResponseEntity<>(this.service.getClaimById(claimId), HttpStatus.FOUND);
    }

    // update claim by id
    @PutMapping("/{claimId}")
    public ResponseEntity<ClaimDTO> updateClaim(@PathVariable Integer claimId,@Valid @RequestBody ClaimDTO claimDTO){
        return new ResponseEntity<>(this.service.updateClaim(claimId, claimDTO), HttpStatus.OK);
    }

    // delete a specific claim by id
    @DeleteMapping("/{claimId}")
    public ResponseEntity<APIResponse> deleteClaim(@PathVariable Integer claimId){
        this.service.deleteClaim(claimId);
        return new ResponseEntity<>(new APIResponse("claim deleted with id: " + claimId), HttpStatus.BAD_REQUEST);
    }
}
