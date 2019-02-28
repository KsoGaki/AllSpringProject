package fr.afpa.formation.exception.client;

public class ClientNotValidException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ClientNotValidException(String message) {
        super(message);
    }
}
