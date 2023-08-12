package io.com.order.api.ordermanagement.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Document(collection = "orders")
/**
 * The Order class represents an order placed by a buyer.
 * @author abhis
 */
public class Order {

    /**
     * The name of the sequence associated with orders.
     */
    @Transient
    public static final String SEQUENCE_NAME = "order_sequence";

    /**
     * The unique identifier of the order.
     */
    @Id
    private Long id;
    /**
     * The identifier of the buyer who placed the order.
     */
    private Long buyerId;

    /**
     * The list of products included in the order.
     */
    private List<String> products;

}
