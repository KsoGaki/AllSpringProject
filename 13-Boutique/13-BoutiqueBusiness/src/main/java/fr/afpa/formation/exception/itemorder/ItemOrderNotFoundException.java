package fr.afpa.formation.exception.itemorder;


public class ItemOrderNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ItemOrderNotFoundException(String message) {
		super(message);
	}
}
