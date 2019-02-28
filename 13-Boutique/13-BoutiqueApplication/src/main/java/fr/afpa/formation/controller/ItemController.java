package fr.afpa.formation.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.afpa.formation.entity.CartItem;
import fr.afpa.formation.entity.Item;
import fr.afpa.formation.entity.ItemOrder;
import fr.afpa.formation.entity.Order;
import fr.afpa.formation.exception.itemorder.ItemOrderAlreadyExistsException;
import fr.afpa.formation.exception.itemorder.ItemOrderNotValidException;
import fr.afpa.formation.exception.order.OrderAlreadyExistsException;
import fr.afpa.formation.exception.order.OrderNotValidException;
import fr.afpa.formation.service.CartService;
import fr.afpa.formation.service.ItemOrderService;
import fr.afpa.formation.service.ItemService;
import fr.afpa.formation.service.OrderService;

@Controller
public class ItemController {

	@Autowired
	ItemService itemService;

	@Autowired
	CartService cartService;

	@Autowired
	OrderService orderService;

	@Autowired
	ItemOrderService itemOrderService;

	@Autowired
	HttpServletRequest httpServletRequest;

	@RequestMapping("/")
	public String listItem(Model model) {
		List<Item> listItem = itemService.findAll();
		List<String> listFill = new ArrayList<String>();
		for(int i = listItem.size()% 4; i > 0; i-- ) {
			listFill.add("");
		}
		model.addAttribute("listItem", listItem);
		model.addAttribute("listFill", listFill);
		model.addAttribute("nbItem", cartService.findAll(httpServletRequest.getSession()).size());
		return "item";
	}

	@RequestMapping({"/cart"})
	public String listCart(Model model) {
		List<CartItem> listCartItem = cartService.findAll(httpServletRequest.getSession());
		model.addAttribute("nbItem", cartService.findAll(httpServletRequest.getSession()).size());
		model.addAttribute("listCartItem", listCartItem);
		return "cart";
	}

	@RequestMapping({"/addToCart"})
	public String addToCart(@RequestParam(name="id", required=true) Long id) {
		Item item = itemService.findById(id);
		cartService.addToCart(httpServletRequest.getSession(), item);
		return "redirect:../cart";
	}

	@RequestMapping({"/removeFromCart"})
	public String removeFromCart(@RequestParam(name="id", required=true) Long id) {
		Item item = itemService.findById(id);
		cartService.removeFromCart(httpServletRequest.getSession(), item);
		return "redirect:../cart";
	}

	@RequestMapping({"/changeQuantity"})
	public String changeQuantity(@RequestParam(name="id", required=true) Long id,
			@RequestParam(name="quantity", required=true) int quantity) {
		Item item = itemService.findById(id);
		cartService.changeQuantity(httpServletRequest.getSession(), item, quantity);
		return "redirect:../cart";
	}

	@RequestMapping({"/cart/payment"})
	public String payment(Model model) {
		List<CartItem> listCartItem = cartService.findAll(httpServletRequest.getSession());
		float total = 0;
		if(listCartItem.size() == 0) {
			return "redirect:../";
		}
		for(CartItem cartItem: listCartItem) {
			total += (cartItem.getItem().getPrice() * cartItem.getQuantity());
		}
		model.addAttribute("nbItem", cartService.findAll(httpServletRequest.getSession()).size());
		model.addAttribute("listCartItem", listCartItem);
		model.addAttribute("total", total);
		return "payment";
	}

	@RequestMapping({"/cart/clear"})
	public String clearCart(Model model) {
		cartService.clear(httpServletRequest.getSession());
		return "redirect:/cart";
	}

	@RequestMapping({"/cart/payment/valid"})
	public String addPayment(Model model) {
		List<CartItem> listCartItem = cartService.findAll(httpServletRequest.getSession());
		Order order = null;
		try {
			order = orderService.create(new Order(new Date(2019)));
		} catch (OrderNotValidException | OrderAlreadyExistsException e) {

			e.printStackTrace();
		}
		for(CartItem cartItem : listCartItem) {
			ItemOrder itemOrder = new ItemOrder(cartItem.getItem(), order, cartItem.getQuantity());
			try {
				itemOrderService.create(itemOrder);
			} catch (ItemOrderNotValidException | ItemOrderAlreadyExistsException e) {
				e.printStackTrace();
			}
		}
		cartService.clear(httpServletRequest.getSession());
		return "redirect:/";
	}

}
