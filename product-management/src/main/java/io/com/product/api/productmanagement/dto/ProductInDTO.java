package io.com.product.api.productmanagement.dto;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
/**
 * The ProductInDto class represents the input data transfer object for a product.
 * It contains the details of a product to be created or updated.
 * @author abhis
 */
public class ProductInDTO {
	
	/**
	 * The ID of the product.
	 */
	private Long id;
	
	/**
	 * The name of the product.
	 */
	private String name;
	
	/**
	 * The description of the product.
	 */
	private String description;
	
	/**
	 * The price of the product.
	 */
	private Double price;
	
	/**
	 * The discount applied to the product.
	 */
	private Double discount;
	
	/**
	 * The manufacturer of the product.
	 */
	private String manufacturedBy;
	
	/**
	 * The quantity of the product.
	 */
	private Long quantity;
}

