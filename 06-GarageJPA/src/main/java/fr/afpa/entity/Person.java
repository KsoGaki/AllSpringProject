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
	
	@Column(name="firstName", columnDefinition="VARCHAR(50)", nullable=false)
	private String firstName;
	
	@Column(name="lastName", columnDefinition="VARCHAR(50)", nullable=false)
	private String lastName;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.REFRESH)
	private Set<Vehicule> listVehicule = new HashSet<Vehicule>();

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

	public Set<Vehicule> getListVehicule() {
		return listVehicule;
	}

	public void setListVehicule(Set<Vehicule> listVehicule) {
		this.listVehicule = listVehicule;
	}

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

	@Override
	public String toString() {
		return "\nPerson --> id: " + id 
				+ " | firstName: " + firstName 
				+ " | lastName: " + lastName;
	}	
	
}
