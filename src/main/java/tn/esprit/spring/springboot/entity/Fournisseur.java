package tn.esprit.spring.springboot.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_FOURNISSEUR")
public class Fournisseur implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFournisseur;
	
	private String code;
	
	private String libelle;
	
	@ManyToMany(mappedBy="fournisseurs", cascade = CascadeType.ALL)
	private Set<Produit> produits;
	
	
	public long getIdFournisseur() {
		return idFournisseur;
	}
	public void setIdFournisseur(long idFournisseur) {
		this.idFournisseur = idFournisseur;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	
	
}
