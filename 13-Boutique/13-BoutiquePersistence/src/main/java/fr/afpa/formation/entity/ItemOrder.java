package fr.afpa.formation.entity;

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
@Table(name="Item_Order")
public class ItemOrder {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_ItemOrder")
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_Item", nullable=false)
	private Item item;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_Order", nullable=false)
	private Order order;

	@Column(name="quantity", nullable = false, length = 10)
	private Integer quantity;

	public ItemOrder(Long id, Item item, Order order, Integer quantity) {
		super();
		this.id = id;
		this.item = item;
		this.order = order;
		this.quantity = quantity;
	}

	public ItemOrder(Item item, Order order, Integer quantity) {
		super();
		this.item = item;
		this.order = order;
		this.quantity = quantity;
	}

	public ItemOrder() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}



}
