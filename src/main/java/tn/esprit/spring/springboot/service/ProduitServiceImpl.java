package tn.esprit.spring.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.springboot.entity.*;
import tn.esprit.spring.springboot.repository.ProduitRepository;
import tn.esprit.spring.springboot.repository.StockRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private StockService stockService;
    @Autowired
    private RayonService rayonService;

    @Override
    public List<Produit> retrieveAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public Produit addProduit(Produit p, Long idRayon, Long idStock) {

        Stock stock = stockService.retrieveStock(idStock);
        Rayon rayon = rayonService.findById(idRayon);
        if(stock != null && rayon != null){
            p.setStock(stock);
            p.setRayon(rayon);
            DetailProduit dp = new DetailProduit(CategorieProduit.ALIMENTAIRE, p);
            p.setDetailProduit(dp);
            return produitRepository.save(p);
        }
        return null;
    }

    @Override
    public Produit retrieveProduit(Long id) {
        return produitRepository.findById(id).orElse(null);
    }
}
