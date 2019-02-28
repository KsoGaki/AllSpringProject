package fr.afpa.formation.exception.comment;


public class CommentNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CommentNotAvailableException(String message) {
		super(message);
	}
}
