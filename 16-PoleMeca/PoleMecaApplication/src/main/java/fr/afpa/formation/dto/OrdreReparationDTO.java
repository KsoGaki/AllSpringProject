package fr.afpa.formation.dto;

import java.util.Date;

import fr.afpa.formation.entity.OrdreReparation;

public class OrdreReparationDTO implements IDTO {

	private Long id;
	private Date dateCreation;
	private Date dateEntree;
	private Date dateSortie;
	private String symptomesClient;
	private String interventionARealiser;
	private String interventionRealisee;
	private Long idVehicule;

	public OrdreReparationDTO() {}

	public OrdreReparationDTO(OrdreReparation ordreReparation) {
		this.id = ordreReparation.getId();
		this.dateCreation = ordreReparation.getDateCreation();
		this.dateEntree = ordreReparation.getDateEntree();
		this.dateSortie = ordreReparation.getDateSortie();
		this.symptomesClient = ordreReparation.getSymptomesClient();
		this.interventionARealiser = ordreReparation.getInterventionARealiser();
		this.interventionRealisee = ordreReparation.getInterventionRealisee();
		this.idVehicule = ordreReparation.getVehicule().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public String getSymptomesClient() {
		return symptomesClient;
	}

	public void setSymptomesClient(String symptomesClient) {
		this.symptomesClient = symptomesClient;
	}

	public String getInterventionARealiser() {
		return interventionARealiser;
	}

	public void setInterventionARealiser(String interventionARealiser) {
		this.interventionARealiser = interventionARealiser;
	}

	public String getInterventionRealisee() {
		return interventionRealisee;
	}

	public void setInterventionRealisee(String interventionRealisee) {
		this.interventionRealisee = interventionRealisee;
	}

	public Long getIdVehicule() {
		return idVehicule;
	}

	public void setVehicule(Long idVehicule) {
		this.idVehicule = idVehicule;
	}

}
