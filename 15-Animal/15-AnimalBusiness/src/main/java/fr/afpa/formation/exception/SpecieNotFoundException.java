package fr.afpa.formation.exception;


public class SpecieNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SpecieNotFoundException(String message) {
		super(message);
	}
}
