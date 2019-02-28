package fr.afpa.entity;

import java.util.Date;

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
@Table(name="Location")
public class Location {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Location")
	private long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_Box")
	private Box box;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_Vehicule")
	private Vehicule vehicule;
	
	@Column(name="tarif", columnDefinition="FLOAT", nullable=false)
	private double tarif;

	@Column(name="startDate", columnDefinition="DATE", nullable= false)
	private Date startDate;
	
	@Column(name="endDate", columnDefinition="DATE", nullable= false)
	private Date endDate;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Box getBox() {
		return box;
	}

	public void setBox(Box box) {
		this.box = box;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public double getTarif() {
		return tarif;
	}

	public void setTarif(double tarif) {
		this.tarif = tarif;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Location(long id, Box box, Vehicule vehicule, double tarif, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.box = box;
		this.vehicule = vehicule;
		this.tarif = tarif;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Location(Box box, Vehicule vehicule, double tarif, Date startDate, Date endDate) {
		super();
		this.box = box;
		this.vehicule = vehicule;
		this.tarif = tarif;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Location() {
	}

	@Override
	public String toString() {
		return "\n Location --> id: " + id 
				+ " | tarif: " + tarif 
				+ " | startDate: " + startDate 
				+ " | endDate: " + endDate
				+ vehicule.toString();
	}	
	
}
