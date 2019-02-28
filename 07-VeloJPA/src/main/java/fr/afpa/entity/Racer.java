package fr.afpa.entity;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Racer")
public class Racer {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Racer")
	private long id;

	@OneToOne
	@JoinColumn(name="id_Person")
	Person person;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_Team")
	private Team team;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "racer", cascade = CascadeType.ALL)
	private Set<Bike> listBike = new HashSet<Bike>();

	public Racer(long id, Team team, Person person) {
		super();
		this.id = id;
		this.team = team;
		this.person = person;
	}

	public Racer(Team team, Person person) {
		super();
		this.team = team;
		this.person = person;
	}

	public Racer() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Set<Bike> getListBike() {
		return listBike;
	}

	public void setListBike(Set<Bike> listBike) {
		this.listBike = listBike;
	}

	@Override
	public String toString() {
		return "\nRacer --> id: " + id 
				+ person.toString()
				+ listBike.toString().replaceAll("^\\[", "").replaceAll("\\]$", "").replace(",", "");
	}



}
