package tn.esprit.spring.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
	private DetailProduit detailProduit;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn( name = "product_id" )
	Stock stock;
	
	@ManyToOne
	Rayon rayon;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="product")
	private Set<DetailFacture> FactureDetails;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Fournisseur> fournisseurs;

}
