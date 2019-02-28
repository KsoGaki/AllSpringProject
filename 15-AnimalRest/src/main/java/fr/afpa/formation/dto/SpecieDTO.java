package fr.afpa.formation.dto;

public class SpecieDTO {

	private Long id;
	private String commonName;
	private String latinName;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	public String getLatinName() {
		return latinName;
	}
	public void setLatinName(String latinName) {
		this.latinName = latinName;
	}

	public SpecieDTO() {}

	public SpecieDTO(Long id, String commonName, String latinName) {
		super();
		this.id = id;
		this.commonName = commonName;
		this.latinName = latinName;
	}

	public SpecieDTO(String commonName, String latinName) {
		super();
		this.commonName = commonName;
		this.latinName = latinName;
	}

	@Override
	public String toString() {
		return "SpecieDTO - id: " + id 
				+ ", commonName: " + commonName 
				+ ", latinName: " + latinName;
	}

}
