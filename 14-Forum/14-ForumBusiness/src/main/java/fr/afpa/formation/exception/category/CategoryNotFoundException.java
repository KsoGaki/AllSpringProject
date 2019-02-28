package fr.afpa.formation.exception.category;


public class CategoryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CategoryNotFoundException(String message) {
		super(message);
	}
}
