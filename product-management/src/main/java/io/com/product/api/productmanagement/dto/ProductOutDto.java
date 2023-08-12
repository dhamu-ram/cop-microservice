package io.com.product.api.productmanagement.dto;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
/**
 * The ProductOutDto class represents the output data transfer object for a product.
 * It contains the details of a product retrieved or returned by the system.
 * @author abhis
 */
public class ProductOutDto {
	
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

