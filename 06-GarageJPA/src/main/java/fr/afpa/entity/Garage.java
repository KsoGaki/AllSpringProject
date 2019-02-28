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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Garage")
public class Garage {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Garage")
	private long id;

	@Column(name="name", columnDefinition="VARCHAR(50)", nullable=false)
	private String name;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_Address")
	private Address address;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "garage", cascade = CascadeType.REFRESH)
	@OrderBy
	private Set<Box> listBox = new HashSet<Box>();

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Box> getListBox() {
		return listBox;
	}

	public void setListBox(Set<Box> listBox) {
		this.listBox = listBox;
	}

	public Garage(long id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public Garage(String name, Address address) {
		super();
		this.name = name;
		this.address = address;
	}

	public Garage() {
	}

	@Override
	public String toString() {
		return "\nGarage    --> id: " + id 
				+ " | name: " + name 
				+ address.toString()
			    + listBox.toString().replaceAll("^\\[", "").replaceAll("\\]$", "").replace(",", "");
	}




}
