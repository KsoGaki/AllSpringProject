package fr.afpa.formation.exception.ordrereparation;

public class OrdreReparationNotValidException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OrdreReparationNotValidException(String message) {
        super(message);
    }
}
