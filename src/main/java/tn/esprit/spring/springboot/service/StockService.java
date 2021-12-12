package tn.esprit.spring.springboot.service;

import tn.esprit.spring.springboot.entity.Stock;

import java.util.List;

public interface StockService {

    List<Stock> retrieveAllStocks();

    Stock addStock(Stock s);

    Stock updateStock(Stock u);

    Stock retrieveStock(Long id);

    void deleteStock(Long id);

    void assignProduitToStock(Long idProduit, Long idStock);

    void showInEveryMin();

    void calculateRevenue();
}
