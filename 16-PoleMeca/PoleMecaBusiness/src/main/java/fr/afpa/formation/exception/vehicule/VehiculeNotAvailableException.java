package fr.afpa.formation.exception.vehicule;


public class VehiculeNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VehiculeNotAvailableException(String message) {
		super(message);
	}
}
