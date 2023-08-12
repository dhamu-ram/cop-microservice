package io.com.payment.api.paymentmanagement.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Document(collection = "db_sequence")
public class DBSequence {

	@Id
	private String id;
	
	private Long seqNo;
}
