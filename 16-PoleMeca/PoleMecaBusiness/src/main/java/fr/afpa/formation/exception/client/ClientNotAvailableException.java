package fr.afpa.formation.exception.client;


public class ClientNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ClientNotAvailableException(String message) {
		super(message);
	}
}
