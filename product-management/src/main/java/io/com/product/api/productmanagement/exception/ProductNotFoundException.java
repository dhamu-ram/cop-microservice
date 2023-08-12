package io.com.product.api.productmanagement.exception;

public class ProductNotFoundException extends Exception {

	/**
	 * {@summary serial version uid no. }
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * {@summary throw an exception when id found. }
	 * @param message of the exception
	 */
	public ProductNotFoundException(final String message) {
		super(message);
	}

}
