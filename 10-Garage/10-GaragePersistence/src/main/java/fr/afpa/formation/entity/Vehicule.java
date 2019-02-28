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
	@Column(name="id_Vehicule")
	private long id;

	@Column(name="immatriculation", columnDefinition="VARCHAR(25)", nullable=false)
	private String immatriculation;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_Voiture")
	private Voiture voiture;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_Person")
	private Person person;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "vehicule", cascade = CascadeType.REFRESH)
	private Set<Location> listLocaltion = new HashSet<Location>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Set<Location> getListLocaltion() {
		return listLocaltion;
	}

	public void setListLocaltion(Set<Location> listLocaltion) {
		this.listLocaltion = listLocaltion;
	}

	public Vehicule(long id, String immatriculation, Voiture voiture, Person person) {
		super();
		this.id = id;
		this.immatriculation = immatriculation;
		this.voiture = voiture;
		this.person = person;
	}

	public Vehicule(String immatriculation, Voiture voiture, Person person) {
		super();
		this.immatriculation = immatriculation;
		this.voiture = voiture;
		this.person = person;
	}

	public Vehicule() {
	}

	@Override
	public String toString() {
		return "\n Vehicule --> id: " + id 
				+ " | immatriculation: " + immatriculation 
				+ voiture 
				+ person;
	}



}
