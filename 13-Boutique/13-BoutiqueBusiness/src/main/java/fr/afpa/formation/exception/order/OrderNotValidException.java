package fr.afpa.formation.exception.order;

public class OrderNotValidException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OrderNotValidException(String message) {
        super(message);
    }
}
