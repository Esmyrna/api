package com.backend.api.infrastructure.controllers;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.backend.api.domain.entity.Client;
import com.backend.api.domain.usecases.ClientUseCases;


@RestController
@RequestMapping("/api/client")
public class ClientController {
    private ClientUseCases clientUseCases;

    @Autowired
     public ClientController(com.backend.api.domain.usecases.ClientUseCases clientUseCases) {
      this.clientUseCases = clientUseCases;
    }
 
    @PostMapping
    public Client createClient(@RequestBody Client client){
      return  clientUseCases.createClient(client);
    }

    @GetMapping
    public List<Client> listClients(){
        return clientUseCases.listAllClients();
    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable Long id){
      return clientUseCases.getByIdClient(id);
    }

    @PutMapping("/{id}")
    public Client updateClients(@PathVariable Long id, @RequestBody Client client){
      return clientUseCases.updateClient(id, client);
    }

    @DeleteMapping("/{id}")
    public void deleteClients(@PathVariable Long id){
         clientUseCases.deleteClient(id);
    }
    
   
}