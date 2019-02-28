package fr.afpa.formation.exception.comment;

public class CommentNotValidException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CommentNotValidException(String message) {
        super(message);
    }
}
