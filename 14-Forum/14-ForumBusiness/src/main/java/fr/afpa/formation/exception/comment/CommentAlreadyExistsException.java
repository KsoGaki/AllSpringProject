package fr.afpa.formation.exception.comment;

public class CommentAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public CommentAlreadyExistsException(String message) {
		super(message);
	}
}
