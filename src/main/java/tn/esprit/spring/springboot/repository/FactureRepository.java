package tn.esprit.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.springboot.entity.Facture;

import java.util.List;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {

    @Query("select * from Facture f where f.client == idClient")
    List<Facture> getFacturesByClient(Long idClient);
}
