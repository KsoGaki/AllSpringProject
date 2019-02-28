package fr.afpa.formation.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Orders")
public class Order {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_Order")
	private Long id;

	@Column(name="date", nullable=false)
	private Date date;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.REFRESH)
	private Set<ItemOrder> listItemOrder = new HashSet<ItemOrder>();

	public Order() {}

	public Order(Long id, Date date) {
		super();
		this.id = id;
		this.date = date;
	}
	
	public Order(Date date) {
		super();
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<ItemOrder> getListItemOrder() {
		return listItemOrder;
	}

	public void setListItemOrder(Set<ItemOrder> listItemOrder) {
		this.listItemOrder = listItemOrder;
	}

}
