package fr.afpa.formation.exception;

public class VoitureNotValidException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VoitureNotValidException(String message) {
        super(message);
    }
}
