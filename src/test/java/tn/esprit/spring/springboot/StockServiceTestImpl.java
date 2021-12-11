package tn.esprit.spring.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.springboot.entity.Stock;
import tn.esprit.spring.springboot.service.StockService;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceTestImpl implements StockServiceTest{

    @Autowired
    StockService stockService;

    @Test
    @Override
    public void testAddStock() {
        Stock s = new Stock(100,10,"stock test");
        Stock savedStock= stockService.addStock(s);
        assertEquals(s.getLibelleStock(), savedStock.getLibelleStock());
    }

    @Test
    @Override
    public void testDeleteStock() {
        stockService.deleteStock(2L);
        assertNull(stockService.retrieveStock(2L));
    }

    @Test
    @Override
    public void testRetrieveAllStocks() {
        List<Stock> allStocks = stockService.retrieveAllStocks();
        assertNotEquals(0, allStocks.size());
    }

    @Test
    @Override
    public void testRetrieveStock() {
        Stock stock = stockService.retrieveStock(2L);
        assertEquals(2L, stock.getIdStock());
    }
}
