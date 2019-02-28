package fr.afpa.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Item")
public class Item {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Item")
	long id;
	
	@Column(name="name", columnDefinition = "VARCHAR(40)", nullable=false)
	String name;
	
	@Column(name="code", columnDefinition = "VARCHAR(10)", nullable=false, unique=true)
	String code;
	
	@Column(name="description", columnDefinition = "VARCHAR(255)", nullable=false)
	String description;
	
	@Column(name="price", columnDefinition = "FLOAT(20,2)", nullable=false)
	double price;
	
	@ManyToMany(cascade = {	CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name="Item_Category", joinColumns=@JoinColumn(name="id_Item"), inverseJoinColumns=@JoinColumn(name="id_Category"))
	Set<Category> listCategory;
	
	@OneToMany(mappedBy="item")
	Set<Image> listImage;
	
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<Category> getListCategory() {
		return listCategory;
	}

	public void setListCategory(Set<Category> listCategory) {
		this.listCategory = listCategory;
	}

	public Set<Image> getListImage() {
		return listImage;
	}

	public void setListImage(Set<Image> listImage) {
		this.listImage = listImage;
	}

	public Item(String name, String code, String description, double price) {
		super();
		this.name = name;
		this.code = code;
		this.description = description;
		this.price = price;
		listCategory = new HashSet<>();
		listImage = new HashSet<>();
	}
	
	public Item(long id, String name, String code, String description, double price) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.description = description;
		this.price = price;
		listCategory = new HashSet<>();
		listImage = new HashSet<>();
	}
	
	public Item() {
		listCategory = new HashSet<>();
		listImage = new HashSet<>();
	}
	
	
}
