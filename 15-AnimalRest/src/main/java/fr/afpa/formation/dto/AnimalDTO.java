package fr.afpa.formation.dto;

public class AnimalDTO {
	
	private Long id;
	private String name;
	private int sex;
	private String coatColor;
	private SpecieDTO specieDTO;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public SpecieDTO getSpecie() {
		return specieDTO;
	}
	public void setSpecie(SpecieDTO specieDTO) {
		this.specieDTO = specieDTO;
	}

	@Override
	public String toString() {
		return "\nAnimal - id: " + id 
				+ ", name: " + name 
				+ ", sex: " + sex 
				+ ", coatColor: " + coatColor 
				+ "\n\t" + specieDTO;
	}

	public AnimalDTO(Long id, String name, int sex, String coatColor, SpecieDTO specieDTO) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.coatColor = coatColor;
		this.specieDTO = specieDTO;
	}

	public AnimalDTO(String name, int sex, String coatColor, SpecieDTO specieDTO) {
		super();
		this.name = name;
		this.sex = sex;
		this.coatColor = coatColor;
		this.specieDTO = specieDTO;
	}

	public AnimalDTO() {

	}

}
