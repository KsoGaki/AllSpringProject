package fr.afpa.formation.exception.vehicule;

public class VehiculeNotValidException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VehiculeNotValidException(String message) {
        super(message);
    }
}
