package tn.esprit.spring.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.springboot.entity.Rayon;
import tn.esprit.spring.springboot.entity.Stock;
import tn.esprit.spring.springboot.service.RayonService;
import tn.esprit.spring.springboot.service.StockService;

@RestController
@RequestMapping("/produit")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/add")
    public Stock add(@RequestBody Stock r){
        return this.stockService.addStock(r);
    }

    @GetMapping("/{id}")
    public Stock list(@PathVariable("id") long id){
        return this.stockService.retrieveStock(id);
    }
}