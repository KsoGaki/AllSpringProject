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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Team")
public class Team {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Team")
	private long id;

	@Column(name="teamName")
	private String teamName;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_TeamLeader")
	private Person teamLeader;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="team", cascade=CascadeType.ALL)
	private Set<Racer> listRacer = new HashSet<Racer>();

	@ManyToMany(mappedBy="listTeam")
	private Set<Race> listRace = new HashSet<Race>();

	public Team(long id, String teamName, Person teamLeader) {
		super();
		this.id = id;
		this.teamName = teamName;
		this.teamLeader = teamLeader;
	}

	public Team(String teamName, Person teamLeader) {
		super();
		this.teamName = teamName;
		this.teamLeader = teamLeader;
	}

	public Team() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Person getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(Person teamLeader) {
		this.teamLeader = teamLeader;
	}

	public Set<Racer> getListRacer() {
		return listRacer;
	}

	public void setListRacer(Set<Racer> listRacer) {
		this.listRacer = listRacer;
	}
	
	public Set<Race> getListRace() {
		return listRace;
	}
	
	public void setListRace(Set<Race> listRace) {
		this.listRace = listRace;
	}

	@Override
	public String toString() {
		return "\nTeam --> id: " + id 
				+ " | teamName: " + teamName 
				+ teamLeader.toTeamLeaderString()
				+ listRacer.toString().replaceAll("^\\[", "").replaceAll("\\]$", "").replace(",", "");
	}



}
