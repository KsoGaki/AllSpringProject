package fr.afpa.formation.entity;

import fr.afpa.formation.entity.Item;

public class CartItem {

	private Item item;
	private int quantity;

	public CartItem(Item item) {
		super();
		this.item = item;
		this.quantity = 1;
	}

	public CartItem(Item item, int quantity) {
		super();
		this.item = item;
		this.quantity = quantity;
	}
	
	public CartItem() {}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
