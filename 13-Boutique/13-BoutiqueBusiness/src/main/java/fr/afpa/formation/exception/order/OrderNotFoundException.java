package fr.afpa.formation.exception.order;


public class OrderNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OrderNotFoundException(String message) {
		super(message);
	}
}
