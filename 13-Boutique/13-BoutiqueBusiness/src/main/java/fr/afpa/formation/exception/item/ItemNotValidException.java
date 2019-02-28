package fr.afpa.formation.exception.item;

public class ItemNotValidException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ItemNotValidException(String message) {
        super(message);
    }
}
