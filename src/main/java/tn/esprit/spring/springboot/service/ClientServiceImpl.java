package tn.esprit.spring.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.spring.springboot.entity.Client;
import tn.esprit.spring.springboot.repository.ClientRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService , UserDetailsService {

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client c = clientRepository.findByEmail(username);
        if(c == null){
            log.error("User is not found in the database");
            throw new UsernameNotFoundException("User not found in database!");
        }else {
            log.info("user found in DB");
        }
        Collection<SimpleGrantedAuthority> auths = new ArrayList<>();
        SimpleGrantedAuthority gauth = new SimpleGrantedAuthority(c.getCategorieClient().name());
        auths.add(gauth);
        return new org.springframework.security.core.userdetails.User(c.getEmail(), c.getPassword(), auths);
    }
}
