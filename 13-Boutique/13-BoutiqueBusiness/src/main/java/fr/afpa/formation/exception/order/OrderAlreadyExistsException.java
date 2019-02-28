package fr.afpa.formation.exception.order;

public class OrderAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public OrderAlreadyExistsException(String message) {
		super(message);
	}
}
