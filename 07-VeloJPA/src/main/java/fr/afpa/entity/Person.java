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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Person")
public class Person {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Person")
	private long id;

	@Column(name="firstName")
	private String firstName;

	@Column(name="lastName")
	private String lastName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "teamLeader", cascade = CascadeType.ALL)
	private Set<Team> listTeam = new HashSet<Team>();

	public Person(long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Person() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Team> getListTeam() {
		return listTeam;
	}

	public void setListTeam(Set<Team> listTeam) {
		this.listTeam = listTeam;
	}



	@Override
	public String toString() {
		return "\n\tPerson --> id: " + id 
				+ " | firstName: " + firstName 
				+ " | lastName: " + lastName;
	}

	public String toTeamLeaderString() {
		return "\n\tTeamLeader --> id: " + id 
				+ " | firstName: " + firstName 
				+ " | lastName: " + lastName;
	}


}
