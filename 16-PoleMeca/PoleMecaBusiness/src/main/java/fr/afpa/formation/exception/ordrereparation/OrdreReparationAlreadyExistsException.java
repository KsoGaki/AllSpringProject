package fr.afpa.formation.exception.ordrereparation;

public class OrdreReparationAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public OrdreReparationAlreadyExistsException(String message) {
		super(message);
	}
}
