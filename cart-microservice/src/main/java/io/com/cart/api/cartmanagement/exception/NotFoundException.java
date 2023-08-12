package io.com.cart.api.cartmanagement.exception;

import java.io.Serial;

public class NotFoundException extends Exception {

	/**
	 * Serial Version Id.
	 */
	@Serial
	private static final long serialVersionUID = 3132190833373606031L;

	/**
	 * @param message contains the message due to which exception occurred
	 */
	public NotFoundException(final String message) {
		super(message);
	}
}
