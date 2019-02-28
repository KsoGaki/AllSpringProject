package fr.afpa.formation.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import fr.afpa.formation.entity.Cart;
import fr.afpa.formation.entity.CartItem;
import fr.afpa.formation.entity.Item;

@Service
public class CartService {

	private Cart cart;

	private static final String _CART = "cart"; 

	public void addToCart(HttpSession httpSession, Item item) {
		cart = (Cart) httpSession.getAttribute(_CART);
		if(cart == null) {
			cart = new Cart();
			httpSession.setAttribute(_CART, cart);
		}
		cart.add(item);
	}

	public List<CartItem> findAll(HttpSession httpSession) {
		cart = (Cart) httpSession.getAttribute(_CART);
		if(cart == null) {
			cart = new Cart();
			httpSession.setAttribute(_CART, cart);
		}
		return cart.getListCartItem();
	}

	public void clear(HttpSession httpSession) {
		httpSession.removeAttribute(_CART);
	}

	public void removeFromCart(HttpSession httpSession, Item item) {
		cart = (Cart) httpSession.getAttribute(_CART);
		if(cart == null) {
			cart = new Cart();
			httpSession.setAttribute(_CART, cart);
		}
		cart.remove(item);
	}

	public void changeQuantity(HttpSession httpSession, Item item, int quantity) {
		cart = (Cart) httpSession.getAttribute(_CART);
		if(cart == null) {
			cart = new Cart();
			httpSession.setAttribute(_CART, cart);
		}
		cart.changeQuantity(item, quantity);	
	}

}
