package io.com.payment.api.paymentmanagement.exception;

public class NotFoundException extends Exception {

	/**
	 * Serial Version Id.
	 */
	private static final long serialVersionUID = 3132190833373606031L;

	/**
	 * @param message contains the message due to which exception occured
	 */
	public NotFoundException(final String message) {
		super(message);
	}
}
