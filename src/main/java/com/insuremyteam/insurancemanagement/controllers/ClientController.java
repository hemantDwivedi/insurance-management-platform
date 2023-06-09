package com.insuremyteam.insurancemanagement.controllers;

import com.insuremyteam.insurancemanagement.payload.APIResponse;
import com.insuremyteam.insurancemanagement.payload.ClientDTO;
import com.insuremyteam.insurancemanagement.service.ClientService;
import jakarta.validation.Valid;
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
    public ResponseEntity<ClientDTO> createClient(@Valid @RequestBody ClientDTO clientDAO){
        return new ResponseEntity<>(this.clientService.createClient(clientDAO), HttpStatus.CREATED);
    }

    // fetch all client
    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAllClient(){
        return new ResponseEntity<>(this.clientService.getAllClient(), HttpStatus.FOUND);
    }

    // fetch a specific client by ID
    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Integer clientId){
        return new ResponseEntity<>(this.clientService.getClientById(clientId), HttpStatus.OK);
    }

    // update a client's information
    @PutMapping("/{clientId}")
    public ResponseEntity<ClientDTO> getClientById(@Valid @PathVariable Integer clientId, @RequestBody ClientDTO clientDAO){
        return new ResponseEntity<>(this.clientService.updateClient(clientId, clientDAO), HttpStatus.OK);
    }

    // delete a client by Id
    @DeleteMapping("/{clientId}")
    public ResponseEntity<APIResponse> deleteClient(@PathVariable Integer clientId){
        this.clientService.deleteClientById(clientId);
        return new ResponseEntity<>(new APIResponse("client deleted with id: " + clientId), HttpStatus.BAD_REQUEST);
    }
}
