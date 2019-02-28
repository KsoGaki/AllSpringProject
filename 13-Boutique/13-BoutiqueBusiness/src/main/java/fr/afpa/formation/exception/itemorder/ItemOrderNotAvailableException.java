package fr.afpa.formation.exception.itemorder;


public class ItemOrderNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ItemOrderNotAvailableException(String message) {
		super(message);
	}
}
