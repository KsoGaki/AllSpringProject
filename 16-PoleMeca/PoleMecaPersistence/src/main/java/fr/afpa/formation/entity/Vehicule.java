package fr.afpa.formation.entity;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Vehicule")
public class Vehicule {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Vehicule", nullable = false)
	private Long id;

	@Column(name="modele", nullable = false, length = 50)
	private String modele;

	@Column(name="marque", nullable = false, length = 50)
	private String marque;

	@Column(name="immatriculation", nullable = false, length = 11)
	private String immatriculation;

	@Column(name="kilometrage", nullable = false, length = 15)
	private double kilometrage;

	@Column(name="numeroCarteGrise", nullable = false, length = 150)
	private String numeroCarteGrise;

	@Column(name="numeroAssurance", nullable = false, length = 150)
	private String numeroAssurance;

	@Column(name="vin", nullable = false, length = 50)
	private String vin;

	@Column(name="dateMiseCirculation", nullable = false)
	private Date dateMiseCirculation;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicule", cascade = CascadeType.REFRESH)
	private Set<OrdreReparation> listOrdreReparation = new HashSet<OrdreReparation>();

	@ManyToOne
	@JoinColumn(name="id_Client", nullable = false)
	private Client client;

	public Vehicule() {}

	public Vehicule(Long id, String modele, String marque, String immatriculation, double kilometrage,
			String numeroCarteGrise, String numeroAssurance, String vin, Date dateMiseCirculation,
			Set<OrdreReparation> listOrdreReparation, Client client) {
		super();
		this.id = id;
		this.modele = modele;
		this.marque = marque;
		this.immatriculation = immatriculation;
		this.kilometrage = kilometrage;
		this.numeroCarteGrise = numeroCarteGrise;
		this.numeroAssurance = numeroAssurance;
		this.vin = vin;
		this.dateMiseCirculation = dateMiseCirculation;
		this.listOrdreReparation = listOrdreReparation;
		this.client = client;
	}

	public Vehicule(String modele, String marque, String immatriculation, double kilometrage,
			String numeroCarteGrise, String numeroAssurance, String vin, Date dateMiseCirculation,
			Set<OrdreReparation> listOrdreReparation, Client client) {
		super();
		this.modele = modele;
		this.marque = marque;
		this.immatriculation = immatriculation;
		this.kilometrage = kilometrage;
		this.numeroCarteGrise = numeroCarteGrise;
		this.numeroAssurance = numeroAssurance;
		this.vin = vin;
		this.dateMiseCirculation = dateMiseCirculation;
		this.listOrdreReparation = listOrdreReparation;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public double getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(double kilometrage) {
		this.kilometrage = kilometrage;
	}

	public String getNumeroCarteGrise() {
		return numeroCarteGrise;
	}

	public void setNumeroCarteGrise(String numeroCarteGrise) {
		this.numeroCarteGrise = numeroCarteGrise;
	}

	public String getNumeroAssurance() {
		return numeroAssurance;
	}

	public void setNumeroAssurance(String numeroAssurance) {
		this.numeroAssurance = numeroAssurance;
	}

	public String getVIN() {
		return vin;
	}

	public void setVIN(String vIN) {
		vin = vIN;
	}

	public Date getDateMiseCirculation() {
		return dateMiseCirculation;
	}

	public void setDateMiseCirculation(Date dateMiseCirculation) {
		this.dateMiseCirculation = dateMiseCirculation;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<OrdreReparation> getListOrdreReparation() {
		return listOrdreReparation;
	}

	public void setListOrdreReparation(Set<OrdreReparation> listOrdreReparation) {
		this.listOrdreReparation = listOrdreReparation;
	}

}
