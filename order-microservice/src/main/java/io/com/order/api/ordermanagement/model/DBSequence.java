package io.com.order.api.ordermanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Document(collection = "db_sequence")
/**
 * The DBSequence class represents a database sequence.
 * @author abhis
 */
public class DBSequence {

    /**
     * The identifier for the sequence.
     */
    @Id
    private String id;

    /**
     * The current sequence number.
     */
    private Long seqNo;
}
