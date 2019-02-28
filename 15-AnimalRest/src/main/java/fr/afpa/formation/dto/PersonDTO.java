package fr.afpa.formation.dto;

import java.util.ArrayList;
import java.util.List;


public class PersonDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private int age;
	private List<AnimalDTO> listAnimal;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public List<AnimalDTO> getListAnimal() {
		return listAnimal;
	}
	public void setListAnimal(List<AnimalDTO> listAnimal) {
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

	public PersonDTO(Long id, String firstName, String lastName, int age, List<AnimalDTO> listAnimal) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.listAnimal = listAnimal;
	}

	public PersonDTO(String firstName, String lastName, int age, List<AnimalDTO> listAnimal) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.listAnimal = listAnimal;
	}

	public PersonDTO(long id, String firstName, String lastName, int age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		listAnimal = new ArrayList<>();
	}

	public PersonDTO(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		listAnimal = new ArrayList<>();
	}

	public PersonDTO() {
		listAnimal = new ArrayList<>();
	}

}
