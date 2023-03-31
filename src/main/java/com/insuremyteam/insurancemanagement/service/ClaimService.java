package com.insuremyteam.insurancemanagement.service;

import com.insuremyteam.insurancemanagement.payload.ClaimDTO;

import java.util.List;

public interface ClaimService {
    ClaimDTO createClaim(ClaimDTO claimDTO);
    ClaimDTO getClaimById(Integer claimId);
    List<ClaimDTO> getAllClaim();
    ClaimDTO updateClaim(Integer claimId, ClaimDTO claimDTO);
    void deleteClaim(Integer claimId);
}
