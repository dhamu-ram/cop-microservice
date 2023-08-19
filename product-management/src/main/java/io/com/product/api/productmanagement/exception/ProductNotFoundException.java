package io.com.product.api.productmanagement.exception;

public class ProductNotFoundException extends Exception {

	private static final long serialVersionUID = -2352020574285115642L;

	/**
	 * {@summary throw an exception when id found. }
	 * @param message of the exception
	 */
	public ProductNotFoundException(final String message) {
		super(message);
	}

}
