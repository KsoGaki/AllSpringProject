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
@Table(name="Bike")
public class Bike {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Bike")
	private long id;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="model")
	private String model;
	
	@Column(name="gearNumber")
	private int gearNumber;
	
	@Column(name="chainsetSize")
	private int chainsetSize;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_Racer")
	private Racer racer;

	public Bike(long id, String brand, String model, int gearNumber, int chainsetSize, Racer racer) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.gearNumber = gearNumber;
		this.chainsetSize = chainsetSize;
		this.racer = racer;
	}

	public Bike(String brand, String model, int gearNumber, int chainsetSize, Racer racer) {
		super();
		this.brand = brand;
		this.model = model;
		this.gearNumber = gearNumber;
		this.chainsetSize = chainsetSize;
		this.racer = racer;
	}

	public Bike() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getGearNumber() {
		return gearNumber;
	}

	public void setGearNumber(int gearNumber) {
		this.gearNumber = gearNumber;
	}

	public int getChainsetSize() {
		return chainsetSize;
	}

	public void setChainsetSize(int chainsetSize) {
		this.chainsetSize = chainsetSize;
	}

	public Racer getRacer() {
		return racer;
	}

	public void setRacer(Racer racer) {
		this.racer = racer;
	}

	@Override
	public String toString() {
		return "\nBike --> id: " + id 
				+ " | brand: " + brand 
				+ " | model: " + model 
				+ " | gearNumber: " + gearNumber
				+ " | chainsetSize: " + chainsetSize;
	}
	
	
	
}
