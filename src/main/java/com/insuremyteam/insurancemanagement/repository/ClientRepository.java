package com.insuremyteam.insurancemanagement.repository;

import com.insuremyteam.insurancemanagement.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
