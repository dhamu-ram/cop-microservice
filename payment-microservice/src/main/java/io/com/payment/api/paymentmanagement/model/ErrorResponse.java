package io.com.payment.api.paymentmanagement.model;

import lombok.*;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class ErrorResponse {

	private Instant timestamp;

	private String status;

	private List<String> errorMessages;

}
