package tn.esprit.spring.springboot.service;

import tn.esprit.spring.springboot.entity.Facture;

import java.util.List;

public interface FactureService {
    List<Facture> retrieveAllFactures();
    void cancelFacture(Long id);
    Facture retrieveFacture(Long id);
}
