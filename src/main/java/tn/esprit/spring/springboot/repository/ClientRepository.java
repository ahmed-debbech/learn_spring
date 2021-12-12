package tn.esprit.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.springboot.entity.CategorieClient;
import tn.esprit.spring.springboot.entity.Client;
import tn.esprit.spring.springboot.entity.Profession;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("select c from Client c where c.profession = :profession")
    List<Client> retrieveClientsByProfession(@Param("profession") Profession profession);

    @Modifying
    @Query("update Client c set c.CategorieClient = :categorie where c.profession = :profession")
    int updateClientCategoryByProfession(@Param("categorie")CategorieClient categorieClient, @Param("profession")Profession profession);

    @Modifying
    @Query("delete from Client c where c.CategorieClient = :categorie and c.profession = :profession")
    void deleteClientByCategorieClientAndProfession(@Param("profession") Profession profession, @Param("categorie") CategorieClient categorieClient);

    Client findByEmail(String email);
}
