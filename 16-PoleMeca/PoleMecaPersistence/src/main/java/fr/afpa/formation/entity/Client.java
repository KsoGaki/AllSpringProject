package fr.afpa.formation.entity;

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
@Table(name="Client")
public class Client {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Client", nullable = false)
	private Long id;

	@Column(name="prenom", nullable = false, length = 50)
	private String prenom;

	@Column(name="nom", nullable = false, length = 50)
	private String nom;

	@Column(name="telephone", nullable = false, length = 20)
	private long telephone;

	@Column(name="email", nullable = false, length = 50)
	private String email;

	@Column(name="address", nullable = false, length = 150)
	private String address;

	@Column(name="carteAFPA", nullable = false, length = 50)
	private String carteAFPA;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client", cascade = CascadeType.REFRESH)
	private Set<Vehicule> listVehicule = new HashSet<Vehicule>();

	public Client(Long id, String prenom, String nom, long telephone, String email, String address, String carteAFPA,
			Set<Vehicule> listVehicule) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.telephone = telephone;
		this.email = email;
		this.address = address;
		this.carteAFPA = carteAFPA;
		this.listVehicule = listVehicule;
	}

	public Client(String prenom, String nom, long telephone, String email, String address, String carteAFPA,
			Set<Vehicule> listVehicule) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.telephone = telephone;
		this.email = email;
		this.address = address;
		this.carteAFPA = carteAFPA;
		this.listVehicule = listVehicule;
	}

	public Client() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public long getTelephone() {
		return telephone;
	}

	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCarteAFPA() {
		return carteAFPA;
	}

	public void setCarteAFPA(String carteAFPA) {
		this.carteAFPA = carteAFPA;
	}

	public Set<Vehicule> getListVehicule() {
		return listVehicule;
	}

	public void setListVehicule(Set<Vehicule> listVehicule) {
		this.listVehicule = listVehicule;
	}



}
