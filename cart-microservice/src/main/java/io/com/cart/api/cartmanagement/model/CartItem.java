package io.com.cart.api.cartmanagement.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Document(collection = "cart")
public class CartItem {

    @Transient
    public static final String SEQUENCE_NAME = "cart_sequence";

    @Id
    private Long id;

    private String productName;

    private Integer quantity;

}
