package io.com.payment.api.paymentmanagement.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsufficientBalanceExceptionTest {

	@Test
	public void testBadRequestException() {
		String errorMessage = "Insufficient balance";
		NotFoundException notFoundException = new NotFoundException(errorMessage);
		assertEquals(errorMessage, notFoundException.getMessage());
	}
}
