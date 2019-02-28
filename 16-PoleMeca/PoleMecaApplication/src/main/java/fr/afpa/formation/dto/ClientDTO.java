package fr.afpa.formation.dto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import fr.afpa.formation.entity.Client;
import fr.afpa.formation.entity.Vehicule;
import fr.afpa.formation.serialize.VehiculeListSerializer;

public class ClientDTO implements IDTO {

	private Long id;
	private long telephone;
	private String prenom;
	private String nom;
	private String email;
	private String address;
	private String carteAFPA;
	@JsonSerialize(using = VehiculeListSerializer.class)
	private Set<Vehicule> listVehicule = new HashSet<Vehicule>();

	public ClientDTO() {}

	public ClientDTO(Client client) {
		this.id = client.getId();
		this.prenom = client.getPrenom();
		this.nom = client.getNom();
		this.telephone = client.getTelephone();
		this.email = client.getEmail();
		this.address = client.getAddress();
		this.carteAFPA = client.getCarteAFPA();
		this.listVehicule = client.getListVehicule();
	}

	public ClientDTO(Long id, String prenom, String nom, long telephone, String email, String address, String carteAFPA,
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

	public ClientDTO(String prenom, String nom, long telephone, String email, String address, String carteAFPA,
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
