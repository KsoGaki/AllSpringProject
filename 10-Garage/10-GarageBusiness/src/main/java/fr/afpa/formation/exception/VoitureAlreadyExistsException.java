package fr.afpa.formation.exception;

public class VoitureAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public VoitureAlreadyExistsException(String message) {
		super(message);
	}
}
