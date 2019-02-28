package fr.afpa.formation.persistence.entity;

import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Person")
public class Person {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Person")
	long id;
	@Column(name="firstName")
	String firstName;
	@Column(name="lastName")
	String lastName;
	@Column(name="age")
	int age;
	@ManyToMany(fetch = FetchType.EAGER,cascade= {CascadeType.MERGE})
	@JoinTable(name="animal__person",joinColumns=@JoinColumn(name="id_Person"),inverseJoinColumns=@JoinColumn(name="id_Animal"))
	List<Animal> listAnimal;
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Animal> getListAnimal() {
		return listAnimal;
	}
	public void setListAnimal(List<Animal> listAnimal) {
		this.listAnimal = listAnimal;
	}

	@Override
	public String toString() {
		return "\nPerson - id: " + id 
			 + ", firstName: " + firstName 
			 + ", lastName: " + lastName 
			 + ", age: " + age
		     + "\nList Animals - " + listAnimal;
	}
	
	public Person(long id, String firstName, String lastName, int age, List<Animal> listAnimal) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.listAnimal = listAnimal;
	}
	
	public Person(String firstName, String lastName, int age, List<Animal> listAnimal) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.listAnimal = listAnimal;
	}
	
	public Person(long id, String firstName, String lastName, int age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		listAnimal = new ArrayList<>();
	}
	
	public Person(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		listAnimal = new ArrayList<>();
	}
	
	public Person() {
		listAnimal = new ArrayList<>();
	}

}
