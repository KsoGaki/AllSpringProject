package fr.afpa.formation.exception.ordrereparation;


public class OrdreReparationNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OrdreReparationNotAvailableException(String message) {
		super(message);
	}
}
