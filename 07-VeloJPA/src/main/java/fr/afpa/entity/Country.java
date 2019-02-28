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
@Table(name="Country")
public class Country {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Country")
	private long id;

	@Column(name="countryName")
	private String countryName;
	
	@Column(name="codeName")
	private String codeName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country", cascade = CascadeType.ALL)
	private Set<Place> listPlace = new HashSet<Place>();

	public Country(long id, String countryName, String codeName) {
		super();
		this.id = id;
		this.countryName = countryName;
		this.codeName = codeName;
	}
	
	public Country(String countryName, String codeName) {
		super();
		this.countryName = countryName;
		this.codeName = codeName;
	}
	
	public Country() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public Set<Place> getListPlace() {
		return listPlace;
	}

	public void setListPlace(Set<Place> listPlace) {
		this.listPlace = listPlace;
	}

	@Override
	public String toString() {
		return "\nCountry --> id: " + id 
				+ " | countryName: " + countryName 
				+ " | codeName: " + codeName;
	}
	
	
	
}
