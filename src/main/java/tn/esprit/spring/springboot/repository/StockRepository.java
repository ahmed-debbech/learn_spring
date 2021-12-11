package tn.esprit.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.springboot.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
}
