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

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="T_STOCK")
public class Stock implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idStock;

	@NonNull
	private int qte;
	@NonNull
	private int qteMin;
	@NonNull
	private String libelleStock;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="stock")
	private Set<Produit> Produits;

}
