package fr.afpa.formation.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="OrdreReparation")
public class OrdreReparation {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_OrdreReparation", nullable = false)
	private Long id;

	@Column(name="dateCreation", nullable = false)
	private Date dateCreation;

	@Column(name="dateEntree")
	private Date dateEntree;

	@Column(name="dateSortie")
	private Date dateSortie;

	@Column(name="symptomesClient", nullable = false, length = 500)
	private String symptomesClient;

	@Column(name="interventionARealiser", nullable = false, length = 500)
	private String interventionARealiser;

	@Column(name="interventionRealisee", length = 500)
	private String interventionRealisee;

	@ManyToOne
	@JoinColumn(name="id_Vehicule", nullable = false)
	private Vehicule vehicule;

	public OrdreReparation() {}

	public OrdreReparation(Long id, Date dateCreation, Date dateEntree, Date dateSortie, String symptomesClient,
			String interventionARealiser, String interventionRealisee, Vehicule vehicule) {
		super();
		this.id = id;
		this.dateCreation = dateCreation;
		this.dateEntree = dateEntree;
		this.dateSortie = dateSortie;
		this.symptomesClient = symptomesClient;
		this.interventionARealiser = interventionARealiser;
		this.interventionRealisee = interventionRealisee;
		this.vehicule = vehicule;
	}

	public OrdreReparation(Date dateCreation, Date dateEntree, Date dateSortie, String symptomesClient,
			String interventionARealiser, String interventionRealisee, Vehicule vehicule) {
		super();
		this.dateCreation = dateCreation;
		this.dateEntree = dateEntree;
		this.dateSortie = dateSortie;
		this.symptomesClient = symptomesClient;
		this.interventionARealiser = interventionARealiser;
		this.interventionRealisee = interventionRealisee;
		this.vehicule = vehicule;
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

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

}
