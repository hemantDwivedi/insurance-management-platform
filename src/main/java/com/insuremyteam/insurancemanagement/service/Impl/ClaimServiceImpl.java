package com.insuremyteam.insurancemanagement.service.Impl;

import com.insuremyteam.insurancemanagement.config.ModelMap;
import com.insuremyteam.insurancemanagement.exception.ResourceNotFoundException;
import com.insuremyteam.insurancemanagement.models.Claim;
import com.insuremyteam.insurancemanagement.payload.ClaimDTO;
import com.insuremyteam.insurancemanagement.repository.ClaimRepository;
import com.insuremyteam.insurancemanagement.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    private ClaimRepository repository;
    @Autowired
    private ModelMap modelMap;

    @Override
    public ClaimDTO createClaim(ClaimDTO claimDTO) {
        Claim claim = this.modelMap.modelMapper().map(claimDTO, Claim.class);
        Claim saveClaim = this.repository.save(claim);
        return this.modelMap.modelMapper().map(saveClaim, ClaimDTO.class);
    }

    @Override
    public ClaimDTO getClaimById(Integer claimId) {

        Claim claim = this.repository.findById(claimId).orElseThrow(() -> new ResourceNotFoundException("claim not found with id: " + claimId));
        return this.modelMap.modelMapper().map(claim, ClaimDTO.class);
    }

    @Override
    public List<ClaimDTO> getAllClaim() {
        List<Claim> claimList = this.repository.findAll();
        return claimList
                .stream()
                .map(
                        claim ->  this.modelMap.modelMapper().map(claim, ClaimDTO.class)
                ).collect(Collectors.toList());
    }

    @Override
    public ClaimDTO updateClaim(Integer claimId, ClaimDTO claimDTO) {
        Claim claim = this.repository.findById(claimId).orElseThrow(() -> new ResourceNotFoundException("claim not found with id: " + claimId));
        claim.setClaimNumber(claimDTO.getClaimNumber());
        claim.setDescription(claimDTO.getDescription());
        claim.setClaimDate(claimDTO.getClaimDate());
        claim.setClaimStatus(claimDTO.getClaimStatus());
        this.repository.save(claim);
        return this.modelMap.modelMapper().map(claim, ClaimDTO.class);
    }

    @Override
    public void deleteClaim(Integer claimId) {
        Claim claim = this.repository.findById(claimId).orElseThrow(() -> new ResourceNotFoundException("claim not found with id: " + claimId));
        this.repository.delete(claim);
    }
}
