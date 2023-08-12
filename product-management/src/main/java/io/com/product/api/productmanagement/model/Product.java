package io.com.product.api.productmanagement.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document("Product")
public class Product {

	@Id
	private Long productId;

	@NotEmpty(message = "Prodcut name can not be null or empty")
	private String name;

	@NotEmpty(message = "Prodcut description can not be null or empty")
	private String description;

	@NotNull(message = "Prodcut quantity can not be null or empty")
	private Long quantity;

	@NotNull(message = "Prodcut price can not be null or empty")
	private double price;

	@NotEmpty(message = "Manufacturer can not be null or empty")
	private String manufacturedBy;

	@NotNull(message = "Discount price can not be null or empty")
	private double discount;

}
