package tn.esprit.spring.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.springboot.entity.Client;
import tn.esprit.spring.springboot.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/list")
    public List<Client> getCLients(){
        return  this.clientService.retrieveAllClients();
    }

    @PostMapping("/add")
    public Client addClient(@RequestBody Client client){
        return this.clientService.addClient(client);
    }

    @DeleteMapping("/delete")
    public void del(@RequestBody Client client){
        this.clientService.deleteClient(client.getIdClient());
    }

    @PutMapping("/modify")
    public Client modClient(@RequestBody Client client){
        return this.clientService.updateClient(client);
    }

}
