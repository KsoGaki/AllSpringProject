package fr.afpa.formation.entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private List<CartItem> listCartItem = new ArrayList<CartItem>();	

	public void add(Item item) {
		for(CartItem cartItem : listCartItem) {
			if(cartItem.getItem().getId() == item.getId()) {
				cartItem.setQuantity(cartItem.getQuantity()+1);
				return;
			}
		}
		listCartItem.add(new CartItem(item));
	}

	public void remove(Item item) {
		for(CartItem cartItem : listCartItem) {
			if(cartItem.getItem().getId() == item.getId()) {
				listCartItem.remove(cartItem);
				return;
			}
		}
	}

	public void changeQuantity(Item item, int quantity) {
		for(CartItem cartItem : listCartItem) {
			if(cartItem.getItem().getId() == item.getId()) {
				cartItem.setQuantity(quantity);
				return;
			}
		}
	}

	public Cart(List<CartItem> listCartItem) {
		super();
		this.listCartItem = listCartItem;
	}

	public Cart() {}

	public List<CartItem> getListCartItem() {
		return listCartItem;
	}

	public void setListCartItem(List<CartItem> listCartItem) {
		this.listCartItem = listCartItem;
	}

}
