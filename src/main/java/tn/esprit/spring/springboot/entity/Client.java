package tn.esprit.spring.springboot.entity;

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
	
	public long getIdClient() {
		return idClient;
	}
	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public CategorieClient getCategorieClient() {
		return CategorieClient;
	}
	public void setCategorieClient(CategorieClient categorieClient) {
		CategorieClient = categorieClient;
	}
	public Profession getProfession() {
		return profession;
	}
	public void setProfession(Profession profession) {
		this.profession = profession;
	}
	
	
}
