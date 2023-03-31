package com.insuremyteam.insurancemanagement.service.Impl;

import com.insuremyteam.insurancemanagement.config.ModelMap;
import com.insuremyteam.insurancemanagement.exception.ResourceNotFoundException;
import com.insuremyteam.insurancemanagement.models.Client;
import com.insuremyteam.insurancemanagement.payload.ClientDTO;
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
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = this.modelMap.modelMapper().map(clientDTO, Client.class);
        Client saveClient = this.clientRepository.save(client);
        return this.modelMap.modelMapper().map(saveClient, ClientDTO.class);
    }

    @Override
    public List<ClientDTO> getAllClient() {
        List<Client> clientList = this.clientRepository.findAll();
        return clientList
                .stream()
                .map(
                        client -> this.modelMap.modelMapper().map(client, ClientDTO.class)
                ).collect(Collectors.toList());
    }

    @Override
    public ClientDTO updateClient(Integer clientId, ClientDTO clientDTO) {
        Client client = this.clientRepository.findById(clientId).orElseThrow(
                () -> new ResourceNotFoundException("client not found with id: " + clientId)
        );
        if (client != null) {
            client.setName(clientDTO.getName());
            client.setDateOfBirth(clientDTO.getDateOfBirth());
            client.setAddress(clientDTO.getAddress());
            client.setContact(clientDTO.getContact());
            this.clientRepository.save(client);
        }
        return this.modelMap.modelMapper().map(client, ClientDTO.class);
    }

    @Override
    public ClientDTO getClientById(Integer clientId) {
        Client client = this.clientRepository.findById(clientId).orElseThrow(
                () -> new ResourceNotFoundException("client not found with id: " + clientId)
        );
        return this.modelMap.modelMapper().map(client, ClientDTO.class);
    }

    @Override
    public void deleteClientById(Integer clientId) {
        Client client = this.clientRepository.findById(clientId).orElseThrow(
                () -> new ResourceNotFoundException("client not found with id: " + clientId)
        );
        this.clientRepository.delete(client);
    }
}
