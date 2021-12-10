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
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="T_STOCK")
@RequiredArgsConstructor
public class Stock implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idStock;
	
	private int qte;
	
	private int qteMin;
	
	private String libelleStock;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="stock")
	private Set<Produit> Produits;

	public long getIdStock() {
		return idStock;
	}
	public void setIdStock(long idStock) {
		this.idStock = idStock;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public int getQteMin() {
		return qteMin;
	}
	public void setQteMin(int qteMin) {
		this.qteMin = qteMin;
	}
	public String getLibelleStock() {
		return libelleStock;
	}
	public void setLibelleStock(String libelleStock) {
		this.libelleStock = libelleStock;
	}
	
	
}
