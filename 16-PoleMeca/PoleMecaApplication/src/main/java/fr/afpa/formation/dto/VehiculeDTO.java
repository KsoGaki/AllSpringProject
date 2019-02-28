package fr.afpa.formation.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import fr.afpa.formation.entity.OrdreReparation;
import fr.afpa.formation.entity.Vehicule;
import fr.afpa.formation.serialize.OrdreReparationListSerializer;

public class VehiculeDTO implements IDTO {

	private Long id;
	private String modele;
	private String marque;
	private String immatriculation;
	private double kilometrage;
	private String numeroCarteGrise;
	private String numeroAssurance;
	private String vin;
	private Date dateMiseCirculation;
	private Long idClient;
	@JsonSerialize(using = OrdreReparationListSerializer.class)
	private Set<OrdreReparation> listOrdreReparation = new HashSet<OrdreReparation>();

	public VehiculeDTO() {}

	public VehiculeDTO(Vehicule vehicule) {
		this.id = vehicule.getId();
		this.modele = vehicule.getModele();
		this.marque = vehicule.getMarque();
		this.immatriculation = vehicule.getImmatriculation();
		this.kilometrage = vehicule.getKilometrage();
		this.numeroCarteGrise = vehicule.getNumeroCarteGrise();
		this.numeroAssurance = vehicule.getNumeroAssurance();
		this.vin = vehicule.getVIN();
		this.dateMiseCirculation = vehicule.getDateMiseCirculation();
		this.listOrdreReparation = vehicule.getListOrdreReparation();
		this.idClient = vehicule.getClient().getId();
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

	public Long getIdClient() {
		return idClient;
	}

	public void setClient(Long idClient) {
		this.idClient = idClient;
	}

	public Set<OrdreReparation> getListOrdreReparation() {
		return listOrdreReparation;
	}

	public void setListOrdreReparation(Set<OrdreReparation> listOrdreReparation) {
		this.listOrdreReparation = listOrdreReparation;
	}

}
