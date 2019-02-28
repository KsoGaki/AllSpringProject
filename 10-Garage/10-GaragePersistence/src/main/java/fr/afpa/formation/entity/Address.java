package  fr.afpa.formation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Address")
public class Address {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Address")
	private long id;

	@Column(name="adresse", columnDefinition="VARCHAR(100)", nullable=false)
	private String adresse;

	@Column(name="postalCode", columnDefinition="INT(5)", nullable=false)
	private int postalCode;

	@Column(name="ville", columnDefinition="VARCHAR(50)", nullable=false)
	private String ville;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Address(long id, String adresse, int postalCode, String ville) {
		super();
		this.id = id;
		this.adresse = adresse;
		this.postalCode = postalCode;
		this.ville = ville;
	}

	public Address(String adresse, int postalCode, String ville) {
		super();
		this.adresse = adresse;
		this.postalCode = postalCode;
		this.ville = ville;
	}

	public Address() {
	}

	@Override
	public String toString() {
		return "\nAddress   --> id: " + id 
			 + " | adresse: " + adresse 
			 + " | postalCode: " + postalCode 
			 + " | ville: " + ville;
	}
	
	


}
