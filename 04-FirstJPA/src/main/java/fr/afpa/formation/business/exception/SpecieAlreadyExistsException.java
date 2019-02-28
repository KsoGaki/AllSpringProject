package fr.afpa.formation.business.exception;

public class SpecieAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public SpecieAlreadyExistsException(String message) {
		super(message);
	}
}
