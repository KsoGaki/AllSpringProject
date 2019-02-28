package fr.afpa.formation.exception.category;

public class CategoryNotValidException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CategoryNotValidException(String message) {
        super(message);
    }
}
