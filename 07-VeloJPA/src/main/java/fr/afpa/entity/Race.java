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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Race")
public class Race {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Race")
	private long id;

	@Column(name="raceName")
	private String raceName;

	@OneToOne
	private Place place;

	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinTable(name = "race_team", joinColumns = @JoinColumn(name = "id_Team"), inverseJoinColumns = @JoinColumn(name = "id_Race"))
	private Set<Team> listTeam = new HashSet<Team>();

	public Race(long id, String raceName, Place place) {
		super();
		this.id = id;
		this.raceName = raceName;
		this.place = place;
	}

	public Race(String raceName, Place place) {
		super();
		this.raceName = raceName;
		this.place = place;
	}

	public Race() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRaceName() {
		return raceName;
	}

	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Set<Team> getListTeam() {
		return listTeam;
	}

	public void setListTeam(Set<Team> listTeam) {
		this.listTeam = listTeam;
	}

	@Override
	public String toString() {
		return "\nRace --> id: " + id 
				+ " | raceName: " + raceName 
				+ " | place: " + place.toString() 
				+ listTeam.toString().replaceAll("^\\[", "").replaceAll("\\]$", "").replace(",", "");
	}



}
