package tn.esprit.spring.springboot.entity;

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

  @OneToOne(mappedBy="produitDetail")
  private Produit produit;

    public DetailProduit(CategorieProduit categorieProduit, Produit p) {
        dateCreation = new Date();
        this.categorieProduit = categorieProduit;
        this.produit = p;
    }


    public long getIdDetailProduit() {
	return idDetailProduit;
}

public void setIdDetailProduit(long idDetailProduit) {
	this.idDetailProduit = idDetailProduit;
}

public Date getDateCreation() {
	return dateCreation;
}

public void setDateCreation(Date dateCreation) {
	this.dateCreation = dateCreation;
}

public Date getDateDerniereModif() {
	return dateDerniereModif;
}

public void setDateDerniereModif(Date dateDerniereModif) {
	this.dateDerniereModif = dateDerniereModif;
}

public CategorieProduit getCategorieProduit() {
	return categorieProduit;
}

public void setCategorieProduit(CategorieProduit categorieProduit) {
	this.categorieProduit = categorieProduit;
}
  
}
