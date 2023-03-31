package com.insuremyteam.insurancemanagement.controllers;

import com.insuremyteam.insurancemanagement.payload.ClientDAO;
import com.insuremyteam.insurancemanagement.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;


    // create a new client
    @PostMapping
    public ResponseEntity<ClientDAO> createClient(@RequestBody ClientDAO clientDAO){
        return new ResponseEntity<>(this.clientService.createClient(clientDAO), HttpStatus.CREATED);
    }

    // fetch all client
    @GetMapping
    public ResponseEntity<List<ClientDAO>> getAllClient(){
        return new ResponseEntity<>(this.clientService.getAllClient(), HttpStatus.FOUND);
    }

    // fetch a specific client by Id
    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDAO> getClientById(@PathVariable Integer clientId){
        return new ResponseEntity<>(this.clientService.getClientById(clientId), HttpStatus.OK);
    }

    // update a client's information
    @PutMapping("/{clientId}")
    public ResponseEntity<ClientDAO> getClientById(@PathVariable Integer clientId, @RequestBody ClientDAO clientDAO){
        return new ResponseEntity<>(this.clientService.updateClient(clientId, clientDAO), HttpStatus.OK);
    }

    // delete a client by Id
    @DeleteMapping("/{clientId}")
    public String deleteClient(@PathVariable Integer clientId){
        this.clientService.deleteClientById(clientId);
        return "client deleted with id: " + clientId;
    }
}
