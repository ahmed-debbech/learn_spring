package tn.esprit.spring.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="T_CLIENT")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idClient;
	
	private String nom;
	private String prenom;

	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	private CategorieClient CategorieClient;
	
	
	@Enumerated(EnumType.STRING)
	private Profession profession;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Facture> Factures;

	
}
