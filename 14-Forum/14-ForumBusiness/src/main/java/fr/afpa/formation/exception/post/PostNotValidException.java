package fr.afpa.formation.exception.post;

public class PostNotValidException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PostNotValidException(String message) {
        super(message);
    }
}
