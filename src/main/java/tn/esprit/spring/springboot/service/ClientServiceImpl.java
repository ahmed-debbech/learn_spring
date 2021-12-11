package tn.esprit.spring.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.springboot.entity.Client;
import tn.esprit.spring.springboot.repository.ClientRepository;

import java.util.List;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> retrieveAllClients() {
        log.info("entered method retrieve all clients");
        return clientRepository.findAll();
    }

    @Override
    public Client addClient(Client c) {
        log.info("entered method add client");
        return clientRepository.save(c);
    }

    @Override
    public void deleteClient(Long id) {
        log.info("entered method delete" + id + " clients");
        clientRepository.deleteById(id);
    }

    @Override
    public Client updateClient(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public Client retrieveClient(Long id) {
        return clientRepository.findById(id).orElse(null);
    }
}
