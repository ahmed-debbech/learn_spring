package tn.esprit.spring.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="T_DETAILFACTURE")
public class DetailFacture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDetailFacture;
	private int qte;
	private float prixTotal;
	private int pourcentageRemise;
	private float montantRemise;
	
	@OneToOne
	private Produit product;
	
	@ManyToOne
	private Facture facture;

	public DetailFacture(int qte, float prixTotal, int pourcentageRemise, float montantRemise) {
		this.qte = qte;
		this.prixTotal = prixTotal;
		this.pourcentageRemise = pourcentageRemise;
		this.montantRemise = montantRemise;
	}

}
