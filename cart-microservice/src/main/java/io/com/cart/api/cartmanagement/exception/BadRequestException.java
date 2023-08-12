package io.com.cart.api.cartmanagement.exception;

import java.io.Serial;

/**
 * This class contains bad request exception which return 400 status code.
 */
public class BadRequestException extends Exception {

    /**
     * Serial Version Id.
     */
    @Serial
    private static final long serialVersionUID = 3555917544093150908L;

    /**
     * @param message contains the message due to which exception occurred
     * */
    public BadRequestException(final String message) {
        super(message);
      }
}
