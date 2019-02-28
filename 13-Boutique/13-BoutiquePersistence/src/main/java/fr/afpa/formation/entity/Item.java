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
@Table(name="Item")
public class Item {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Item")
	private Long id;
	
	@Column(name="code", nullable = false, length = 15)
	private String code;
	
	@Column(name="name", nullable = false, length = 100)
	private String name;
	
	@Column(name="price", nullable = false, length = 11)
	private Double price;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_Category", nullable=false)
	private Category category;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "item", cascade = CascadeType.REFRESH)
	private Set<ItemOrder> listItemOrder = new HashSet<ItemOrder>();

	public Item() {}

	public Item(Long id, String code, String name, Double price, Category category) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.price = price;
		this.category = category;
	}
	
	public Item(String code, String name, Double price, Category category) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<ItemOrder> getListItemOrder() {
		return listItemOrder;
	}

	public void setListItemOrder(Set<ItemOrder> listItemOrder) {
		this.listItemOrder = listItemOrder;
	}
	
}
