package tn.esprit.spring.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="T_FACTURE")
public class Facture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFacture;
	
	private float montantRemise;
	private float montantFacture;
	
	
	@Temporal(TemporalType.DATE)
	private Date dateFacture;
	
	
	private boolean active;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="facture")
	private Set<DetailFacture> FactureDetails;
	
	@ManyToOne
	Client client;
	
	
}
