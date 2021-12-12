package tn.esprit.spring.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.springboot.entity.Produit;
import tn.esprit.spring.springboot.entity.Rayon;
import tn.esprit.spring.springboot.service.ProduitService;
import tn.esprit.spring.springboot.service.RayonService;

import java.util.List;

@RestController
@RequestMapping("/rayon")
public class RayonController {

    @Autowired
    private RayonService rayonService;

    @PostMapping("/add")
    public Rayon add(@RequestBody Rayon r){
        return this.rayonService.add(r);
    }

    @GetMapping("/{id}")
    public Rayon list(@PathVariable("id") long id){
        return this.rayonService.findById(id);
    }

}