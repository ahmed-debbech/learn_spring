package tn.esprit.spring.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.springboot.entity.Produit;
import tn.esprit.spring.springboot.entity.Stock;
import tn.esprit.spring.springboot.repository.ProduitRepository;
import tn.esprit.spring.springboot.repository.StockRepository;

import java.util.List;

@Slf4j
@Service
public class StockServiceImpl implements StockService{

    @Autowired
    private StockRepository stockRepository;


    @Autowired
    private ProduitRepository produitService;

    @Override
    public List<Stock> retrieveAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock addStock(Stock s) {
        return stockRepository.save(s);
    }

    @Override
    public Stock updateStock(Stock u) {
        return stockRepository.save(u);
    }

    @Override
    public Stock retrieveStock(Long id) {
        return stockRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }

    @Override
    public void assignProduitToStock(Long idProduit, Long idStock) {
        Stock st = stockRepository.findById(idStock).orElse(null);
        if(st != null){
            Produit p = produitService.getById(idProduit);
            if(p != null){
                st.getProduits().add(p);
                stockRepository.save(st);
            }
        }
    }

    @Override
    @Scheduled(cron = "* */60 * * * * ")
    public void showInEveryMin() {
        log.info("entered showInEveryMin method after the stock ended");
        List<Stock> list = stockRepository.findAll();
        int count = 0;
        for(Stock st : list){
            if(st.getQte() == 0){
                count++;
            }
        }
        if(count == list.size()){
            log.info("WARNING THE STOCK IS EMPTY!!!");
        }
    }

    @Scheduled(cron = "0 0 0 1 * *")
    @Override
    public void calculateRevenue(){
        log.info("entered calculated revenue");
        List<Stock> list = stockRepository.findAll();
        int count = 0;
        for(Stock st : list){
            count += st.getQte();
        }
        log.info("THE WHOLE STOCK IS: " + count);
    }

    @Scheduled(cron = "0 0 22 * * *")
    public void retrieveStatusStock(){
        List<Stock> st = stockRepository.findAll();
        for(Stock s : st){
            log.info(st.toString());
        }
    }
}
