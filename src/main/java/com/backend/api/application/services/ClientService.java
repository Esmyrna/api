package com.backend.api.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

import com.backend.api.domain.entity.Client;
import com.backend.api.domain.usecases.ClientUseCases;
import com.backend.api.infrastructure.repositories.ClientRepository;

import jakarta.persistence.EntityNotFoundException;
 

@Service
public class ClientService implements ClientUseCases {
    private ClientRepository clientRepository;
    
    @Autowired
     public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client createClient(Client client){
        return clientRepository.save(client);
    }

    @Override
    public List<Client> listAllClients(){
        return clientRepository.findAll();
    }

    @Override
    public Client  getByIdClient(Long id){
        if (id == null) {
            throw new EntityNotFoundException("Client not found with id: " + id);
        } else{
             return clientRepository.getById(id);
    }
}

    @Override
    public Client updateClient(Long id, Client client){
        Client idClient =  clientRepository.getById(id);
        if(id == null || client == null){
            throw new EntityNotFoundException("Client not found with id: " + id);
        } else {
            idClient.setName(client.getName());
            idClient.setAge(client.getAge());
            idClient.setCity(client.getCity());
        }
        return clientRepository.save(idClient);
    }

    @Override
    public void deleteClient(Long id){
        if(clientRepository.findById(id) == null){
            throw new EntityNotFoundException("Client not found with id: " + id);
        } else {
            clientRepository.deleteById(id);
        }
    }

    
    
}

