package fr.afpa.formation.entity;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Box")
public class Box {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Box")
	private long id;

	@Column(name="placementNumber", columnDefinition="VARCHAR(25)", nullable=false)
	private String placementNumber;

	@Column(name="area", columnDefinition="FLOAT", nullable=false)
	private double area;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_Garage", nullable=false)
	private Garage garage;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "box", cascade = CascadeType.REFRESH)
	private Set<Location> listLocaltion = new HashSet<Location>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlacementNumber() {
		return placementNumber;
	}

	public void setPlacementNumber(String placementNumber) {
		this.placementNumber = placementNumber;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public Garage getGarage() {
		return garage;
	}

	public void setGarage(Garage garage) {
		this.garage = garage;
	}

	public Box(long id, String placementNumber, double area, Garage garage) {
		super();
		this.id = id;
		this.placementNumber = placementNumber;
		this.area = area;
		this.garage = garage;
	}

	public Box(String placementNumber, double area, Garage garage) {
		super();
		this.placementNumber = placementNumber;
		this.area = area;
		this.garage = garage;
	}

	public Box() {
	}

	@Override
	public String toString() {
		return "\nBox       --> id: " + id 
				+ " | placementNumber: " + placementNumber 
				+ " | area: " + area
				+ listLocaltion.toString().replaceAll("^\\[", "").replaceAll("\\]$", "").replace(",", "");
	}



}
