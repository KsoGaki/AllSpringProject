package fr.afpa.formation.exception.post;


public class PostNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PostNotAvailableException(String message) {
		super(message);
	}
}
