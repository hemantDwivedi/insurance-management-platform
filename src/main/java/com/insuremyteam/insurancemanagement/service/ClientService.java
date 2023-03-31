package com.insuremyteam.insurancemanagement.service;

import com.insuremyteam.insurancemanagement.payload.ClientDAO;

import java.util.List;

public interface ClientService {

    ClientDAO createClient(ClientDAO clientDAO);
    List<ClientDAO> getAllClient();
    ClientDAO updateClient(Integer clientId, ClientDAO clientDAO);
    ClientDAO getClientById(Integer clientId);
    void deleteClientById(Integer clientId);
}
