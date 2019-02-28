package fr.afpa.formation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.entity.Order;
import fr.afpa.formation.exception.order.OrderAlreadyExistsException;
import fr.afpa.formation.exception.order.OrderNotAvailableException;
import fr.afpa.formation.exception.order.OrderNotFoundException;
import fr.afpa.formation.exception.order.OrderNotValidException;
import fr.afpa.formation.reposiroty.OrderRepository;

@Service
public class OrderService implements IService<Order, Exception>{

	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public Order create(Order order) throws OrderNotValidException, OrderAlreadyExistsException {
		if(order == null || order.getDate() == null) {
			throw new OrderNotValidException("Order Not Valid Exception");
		}
		if(order.getId() != null && orderRepository.existsById(order.getId())) {
			throw new OrderAlreadyExistsException("Order Already Exists Exception");
		}
		orderRepository.save(order);
		return order;
	}

	@Override
	public Order findById(Long id) throws OrderNotFoundException {
		Optional<Order> order = orderRepository.findById(id);
		if(!order.isPresent()) {
			throw new OrderNotFoundException("Order Not Found Exception");
		}
		return order.get();
	}

	@Override
	public List<Order> findAll() throws OrderNotAvailableException {
		List<Order> listOrder = (List<Order>) orderRepository.findAll();
		if(listOrder == null) {
			throw new OrderNotAvailableException("Order Not Available Exception");
		}
		return listOrder;
	}

	@Override
	public void deleteById(Long id) throws OrderNotFoundException {
		if(!orderRepository.existsById(id)) {
			throw new OrderNotFoundException("Order Not Found Exception");
		}
		orderRepository.deleteById(id);
	}

	@Override
	public Order update(Order order) throws OrderNotValidException, OrderNotFoundException {
		if(order == null || order.getDate() == null) {
			throw new OrderNotValidException("Order Not Valid Exception");
		}
		if(order.getId() == null || !orderRepository.existsById(order.getId())) {
			throw new OrderNotFoundException("Order Not Found Exception");
		}
		orderRepository.save(order);
		return order;
	}

}
