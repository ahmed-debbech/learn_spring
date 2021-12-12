package tn.esprit.spring.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.springboot.entity.Fournisseur;
import tn.esprit.spring.springboot.repository.FournisseurRepository;

@Service
public class FournisseurService  {

    @Autowired
    FournisseurRepository fournisseurRepository;

    public FournisseurService(){

    }

    public Fournisseur get(long id){
        return fournisseurRepository.getById(id);
    }
}
