package io.com.cart.api.cartmanagement.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BadRequestExceptionTest {

	@Test
	public void testBadRequestException() {
		String errorMessage = "Bad request";
		BadRequestException badRequestException = new BadRequestException(errorMessage);
		assertEquals(errorMessage, badRequestException.getMessage());
	}
}
