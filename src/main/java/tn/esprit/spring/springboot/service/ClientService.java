package tn.esprit.spring.springboot.service;

import tn.esprit.spring.springboot.entity.Client;

import java.util.List;

public interface ClientService {

    List<Client> retrieveAllClients();

    Client addClient(Client c);

    void deleteClient(Long id);

    Client updateClient(Client c);

    Client retrieveClient(Long id);
}
