package fr.afpa.formation.exception.item;

public class ItemAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public ItemAlreadyExistsException(String message) {
		super(message);
	}
}
