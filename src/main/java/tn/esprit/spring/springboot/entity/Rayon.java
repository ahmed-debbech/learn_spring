package tn.esprit.spring.springboot.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_RAYON")
public class Rayon implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRayon;
	
	private String code;
	
	private String libelle;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="rayon")
	private Set<Produit> Produits;
	
	public long getIdRayon() {
		return idRayon;
	}
	public void setIdRayon(long idRayon) {
		this.idRayon = idRayon;
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
