package tn.esprit.spring.springboot.entity;

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
	
	public long getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(long idFacture) {
		this.idFacture = idFacture;
	}
	public float getMontantRemise() {
		return montantRemise;
	}
	public void setMontantRemise(float montantRemise) {
		this.montantRemise = montantRemise;
	}
	public float getMontantFacture() {
		return montantFacture;
	}
	public void setMontantFacture(float montantFacture) {
		this.montantFacture = montantFacture;
	}
	public Date getDateFacture() {
		return dateFacture;
	}
	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
