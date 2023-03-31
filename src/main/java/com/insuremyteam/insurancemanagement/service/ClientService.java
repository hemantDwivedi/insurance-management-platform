package com.insuremyteam.insurancemanagement.service;

import com.insuremyteam.insurancemanagement.payload.ClientDTO;

import java.util.List;

public interface ClientService {

    ClientDTO createClient(ClientDTO clientDTO);
    List<ClientDTO> getAllClient();
    ClientDTO updateClient(Integer clientId, ClientDTO clientDTO);
    ClientDTO getClientById(Integer clientId);
    void deleteClientById(Integer clientId);
}
