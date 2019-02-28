package fr.afpa.formation.exception;


public class SpecieNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SpecieNotAvailableException(String message) {
		super(message);
	}
}
