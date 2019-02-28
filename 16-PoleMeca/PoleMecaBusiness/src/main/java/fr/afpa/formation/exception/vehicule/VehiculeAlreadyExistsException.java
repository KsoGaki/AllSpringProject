package fr.afpa.formation.exception.vehicule;

public class VehiculeAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public VehiculeAlreadyExistsException(String message) {
		super(message);
	}
}
