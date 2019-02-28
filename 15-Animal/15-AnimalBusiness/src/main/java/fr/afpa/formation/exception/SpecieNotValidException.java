package fr.afpa.formation.exception;

public class SpecieNotValidException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SpecieNotValidException(String message) {
        super(message);
    }
}
