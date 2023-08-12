package io.com.cart.api.cartmanagement.model;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class ErrorResponse {

	private Instant timestamp;

	private String status;

	private List<String> errorMessages;

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	public ErrorResponse(Instant timestamp, String status, List<String> errorMessages) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.errorMessages = errorMessages;
	}

	public ErrorResponse() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(errorMessages, status, timestamp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErrorResponse other = (ErrorResponse) obj;
		return Objects.equals(errorMessages, other.errorMessages) && Objects.equals(status, other.status)
				&& Objects.equals(timestamp, other.timestamp);
	}

	@Override
	public String toString() {
		return "ErrorResponse [timestamp=" + timestamp + ", status=" + status + ", errorMessages=" + errorMessages
				+ "]";
	}

	

}
