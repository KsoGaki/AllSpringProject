package fr.afpa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Voiture")
public class Voiture {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Voiture")
	private long id;
	
	@Column(name="modele", columnDefinition="VARCHAR(100)", nullable=false)
	private String modele;
	
	@Column(name="marque", columnDefinition="VARCHAR(100)", nullable=false)
	private String marque;
	
	@Column(name="annee", columnDefinition="date", nullable=false)
	private Date annee;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "voiture", cascade = CascadeType.REFRESH)
	private Set<Vehicule> listVehicule = new HashSet<Vehicule>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public Date getAnnee() {
		return annee;
	}

	public void setAnnee(Date annee) {
		this.annee = annee;
	}

	public Set<Vehicule> getListVehicule() {
		return listVehicule;
	}

	public void setListVehicule(Set<Vehicule> listVehicule) {
		this.listVehicule = listVehicule;
	}

	public Voiture(long id, String modele, String marque, Date annee) {
		super();
		this.id = id;
		this.modele = modele;
		this.marque = marque;
		this.annee = annee;
	}
	
	public Voiture(String modele, String marque, Date annee) {
		super();
		this.modele = modele;
		this.marque = marque;
		this.annee = annee;
	}
	
	public Voiture() {
	}

	@Override
	public String toString() {
		return "\n Voiture  --> id: " + id 
				+ " | modele: " + modele
				+ " | marque: " + marque 
				+ " | annee: " + annee;
	}

	
	
}
