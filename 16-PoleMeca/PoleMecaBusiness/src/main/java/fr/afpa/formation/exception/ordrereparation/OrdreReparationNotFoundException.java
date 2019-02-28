package fr.afpa.formation.exception.ordrereparation;


public class OrdreReparationNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OrdreReparationNotFoundException(String message) {
		super(message);
	}
}
