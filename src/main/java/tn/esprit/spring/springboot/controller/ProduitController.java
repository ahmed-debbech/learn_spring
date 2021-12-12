package tn.esprit.spring.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.springboot.entity.Client;
import tn.esprit.spring.springboot.entity.Produit;
import tn.esprit.spring.springboot.service.ClientService;
import tn.esprit.spring.springboot.service.ProduitService;

import java.util.List;

@RestController
@RequestMapping("/produit")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping("/list")
    public List<Produit> getProduits(){
        return this.produitService.retrieveAllProduits();
    }

    @PostMapping("/add/{ray}/{st}")
    public Produit addProduit(@RequestBody Produit produit, @PathVariable("ray") long ray, @PathVariable("st") long st){
        return this.produitService.addProduit(produit, ray, st);
    }

    @DeleteMapping("/delete/{id}")
    public void del(@PathVariable("id")long id ){
        this.produitService.retrieveProduit(id);
    }

}