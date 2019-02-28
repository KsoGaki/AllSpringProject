package fr.afpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Place")
public class Place {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Place")
	private long id;

	@Column(name="cityName")
	private String cityName;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_Country")
	private Country country;

	public Place(long id, String cityName, Country country) {
		super();
		this.id = id;
		this.cityName = cityName;
		this.country = country;
	}
	
	public Place(String cityName, Country country) {
		super();
		this.cityName = cityName;
		this.country = country;
	}
	
	public Place() {

	 }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "\nPlace --> id: " + id 
				+ " | cityName: " + cityName 
				+ " | country: " + country.toString();
	}
	
	
	
}
