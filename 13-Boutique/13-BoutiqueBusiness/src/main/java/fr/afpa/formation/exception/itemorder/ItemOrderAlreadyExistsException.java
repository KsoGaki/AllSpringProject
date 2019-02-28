package fr.afpa.formation.exception.itemorder;

public class ItemOrderAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public ItemOrderAlreadyExistsException(String message) {
		super(message);
	}
}
