package fr.afpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Category")
public class Category {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Category")
	long id;
	@Column(name="name", columnDefinition = "VARCHAR(40)", nullable=false)
	String name;
	@Column(name="code", columnDefinition = "VARCHAR(10)", nullable=false, unique=true)
	String code;
	@Column(name="description", columnDefinition = "VARCHAR(255)", nullable=false)
	String description;
	
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Category(String name, String code, String description) {
		super();
		this.name = name;
		this.code = code;
		this.description = description;
	}

	
}
