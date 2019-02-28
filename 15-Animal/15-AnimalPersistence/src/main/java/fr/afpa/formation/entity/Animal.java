package fr.afpa.formation.entity;

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
@Table(name="Animal")
public class Animal {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Animal")
	long id;
	@Column(name="name")
	String name;
	@Column(name="sex")
	int sex;
	@Column(name="coatColor")
	String coatColor;
	@ManyToOne
	@JoinColumn(name="id_Specie")
	Specie specie;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getCoatColor() {
		return coatColor;
	}
	public void setCoatColor(String coatColor) {
		this.coatColor = coatColor;
	}
	public Specie getSpecie() {
		return specie;
	}
	public void setSpecie(Specie specie) {
		this.specie = specie;
	}
	
	@Override
	public String toString() {
		return "\nAnimal - id: " + id 
			 + ", name: " + name 
			 + ", sex: " + sex 
			 + ", coatColor: " + coatColor 
			 + "\n\t" + specie;
	}
	
	public Animal(long id, String name, int sex, String coatColor, Specie specie) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.coatColor = coatColor;
		this.specie = specie;
	}
	
	public Animal(String name, int sex, String coatColor, Specie specie) {
		super();
		this.name = name;
		this.sex = sex;
		this.coatColor = coatColor;
		this.specie = specie;
	}
	
	public Animal() {
	
	}
	
}
