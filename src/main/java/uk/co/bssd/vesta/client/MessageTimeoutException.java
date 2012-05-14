package uk.co.bssd.vesta.client;

public class MessageTimeoutException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MessageTimeoutException(String message) {
		super(message);
	}
}