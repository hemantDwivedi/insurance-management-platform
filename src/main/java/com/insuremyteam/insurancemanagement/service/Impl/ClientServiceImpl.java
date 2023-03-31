package com.insuremyteam.insurancemanagement.service.Impl;

import com.insuremyteam.insurancemanagement.config.ModelMap;
import com.insuremyteam.insurancemanagement.exception.ResourceNotFoundException;
import com.insuremyteam.insurancemanagement.models.Client;
import com.insuremyteam.insurancemanagement.payload.ClientDAO;
import com.insuremyteam.insurancemanagement.repository.ClientRepository;
import com.insuremyteam.insurancemanagement.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMap modelMap;

    @Override
    public ClientDAO createClient(ClientDAO clientDAO) {
        Client client = this.modelMap.modelMapper().map(clientDAO, Client.class);
        Client saveClient = this.clientRepository.save(client);
        return this.modelMap.modelMapper().map(saveClient, ClientDAO.class);
    }

    @Override
    public List<ClientDAO> getAllClient() {
        List<Client> clientList = this.clientRepository.findAll();
        return clientList
                .stream()
                .map(
                        client -> this.modelMap.modelMapper().map(client, ClientDAO.class)
                ).collect(Collectors.toList());
    }

    @Override
    public ClientDAO updateClient(Integer clientId, ClientDAO clientDAO) {
        Client client = this.clientRepository.findById(clientId).orElseThrow(
                () -> new ResourceNotFoundException("client not found with id: " + clientId)
        );
        if (client != null) {
            client.setName(clientDAO.getName());
            client.setDateOfBirth(clientDAO.getDateOfBirth());
            client.setAddress(clientDAO.getAddress());
            client.setContact(clientDAO.getContact());
        }
        return this.modelMap.modelMapper().map(client, ClientDAO.class);
    }

    @Override
    public ClientDAO getClientById(Integer clientId) {
        Client client = this.clientRepository.findById(clientId).orElseThrow(
                () -> new ResourceNotFoundException("client not found with id: " + clientId)
        );
        return this.modelMap.modelMapper().map(client, ClientDAO.class);
    }

    @Override
    public void deleteClientById(Integer clientId) {
        Client client = this.clientRepository.findById(clientId).orElseThrow(
                () -> new ResourceNotFoundException("client not found with id: " + clientId)
        );
        this.clientRepository.delete(client);
    }
}
