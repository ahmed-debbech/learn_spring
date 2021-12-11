package tn.esprit.spring.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="T_DETAILPRODUIT")
public class DetailProduit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)	
  private long	idDetailProduit;
  
  @Temporal(TemporalType.DATE)
  private Date dateCreation;
  
  @Temporal(TemporalType.DATE)
  private Date dateDerniereModif;
  
  @Enumerated(EnumType.STRING)
  private CategorieProduit categorieProduit;

  @OneToOne(mappedBy="detailProduit")
  private Produit produit;

    public DetailProduit(CategorieProduit categorieProduit, Produit p) {
        dateCreation = new Date();
        this.categorieProduit = categorieProduit;
        this.produit = p;
    }

  
}
