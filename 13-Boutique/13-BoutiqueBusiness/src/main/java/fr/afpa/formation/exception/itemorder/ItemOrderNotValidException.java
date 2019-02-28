package fr.afpa.formation.exception.itemorder;

public class ItemOrderNotValidException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ItemOrderNotValidException(String message) {
        super(message);
    }
}
