package io.com.cart.api.cartmanagement.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class NotFoundExceptionTest {

	@Test
	public void testBadRequestException() {
		String errorMessage = "Not found";
		NotFoundException notFoundException = new NotFoundException(errorMessage);
		assertEquals(errorMessage, notFoundException.getMessage());
	}
}
