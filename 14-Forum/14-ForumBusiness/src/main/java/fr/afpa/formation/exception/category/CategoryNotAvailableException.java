package fr.afpa.formation.exception.category;


public class CategoryNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CategoryNotAvailableException(String message) {
		super(message);
	}
}
