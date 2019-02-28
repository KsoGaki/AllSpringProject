package fr.afpa.formation.exception.client;

public class ClientAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public ClientAlreadyExistsException(String message) {
		super(message);
	}
}
