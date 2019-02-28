package fr.afpa.formation.exception.order;


public class OrderNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OrderNotAvailableException(String message) {
		super(message);
	}
}
