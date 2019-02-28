package fr.afpa.formation.exception.item;


public class ItemNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ItemNotAvailableException(String message) {
		super(message);
	}
}
