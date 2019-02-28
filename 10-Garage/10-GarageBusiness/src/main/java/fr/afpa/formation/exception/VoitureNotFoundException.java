package fr.afpa.formation.exception;


public class VoitureNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VoitureNotFoundException(String message) {
		super(message);
	}
}
