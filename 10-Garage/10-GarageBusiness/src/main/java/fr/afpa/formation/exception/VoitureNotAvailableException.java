package fr.afpa.formation.exception;


public class VoitureNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VoitureNotAvailableException(String message) {
		super(message);
	}
}
