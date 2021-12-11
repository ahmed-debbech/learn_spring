package tn.esprit.spring.springboot.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="T_PRODUIT")
public class Produit implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProduit;
	
	@Column(name="CODE_PRODUIT", length=10, unique=true, nullable=true)
	private String code;
	
	private String libelle;
	private float prixUnitaire;
	
	@OneToOne(cascade = CascadeType.ALL)
	private DetailProduit produitDetail;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn( name = "product_id" )
	Stock stock;
	
	@ManyToOne
	Rayon rayon;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="product")
	private Set<DetailFacture> FactureDetails;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Fournisseur> fournisseurs;
	
	public long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
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
	public float getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public void setRayon(Rayon r) {
		this.rayon = r;
		
	}
	public void setStock(Stock s) {
		this.stock = s;
		
	}
	public void setDetailProduit(DetailProduit dp) {
		this.produitDetail = dp;
		
	}

	public DetailProduit getProduitDetail() {
		return produitDetail;
	}

	public void setProduitDetail(DetailProduit produitDetail) {
		this.produitDetail = produitDetail;
	}
}
