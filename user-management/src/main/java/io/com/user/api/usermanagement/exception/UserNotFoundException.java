package io.com.user.api.usermanagement.exception;

import java.io.Serial;

public class UserNotFoundException extends Exception{

	/**
	 * serialVersionUID.
	 */
	@Serial
	private static final long serialVersionUID = -3544123876238314530L;

	public UserNotFoundException(String message) {
		super();
	}
}
