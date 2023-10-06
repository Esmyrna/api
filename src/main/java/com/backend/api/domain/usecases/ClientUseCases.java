package com.backend.api.domain.usecases;
import java.util.List;
import com.backend.api.domain.entity.Client;

public interface ClientUseCases {
    Client createClient(Client client);
    List<Client> listAllClients();
    Client getByIdClient(Long id);
    Client updateClient(Long id, Client client);
    void deleteClient(Long id);
}
