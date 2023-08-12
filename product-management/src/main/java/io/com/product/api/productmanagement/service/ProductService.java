package io.com.product.api.productmanagement.service;

import io.com.product.api.productmanagement.dao.ProductRepo;
import io.com.product.api.productmanagement.dto.ProductInDto;
import io.com.product.api.productmanagement.dto.ProductOutDto;
import io.com.product.api.productmanagement.exception.ProductNotFoundException;
import io.com.product.api.productmanagement.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The ProductService class provides business logic for managing products.
 * It handles operations such as creating, retrieving, updating, and deleting products.
 * @author abhis
 */
@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepository;

	/**
	 * Creates a new product based on the ProductInDto.
	 * @param productInDto The input DTO containing the details of the product to be created.
	 * @return The output DTO (ProductOutDto) representing the created product.
	 */

	public ProductOutDto createProduct(ProductInDto productInDto) {

		Product product = new Product();
		product.setProductId(productInDto.getId());
		product.setName(productInDto.getName());
		product.setPrice(productInDto.getPrice());
		product.setManufacturedBy(productInDto.getManufacturedBy());
		product.setDiscount(productInDto.getDiscount());
		product.setDescription(productInDto.getDescription());
		product.setQuantity(productInDto.getQuantity());
		productRepository.save(product);
		return prepareOutDto(product);
	}


	/**
	 * Creates a new product based on the provided ProductInDto.
	 * @param productInDto The input DTO containing the details of the product to be created.
	 * @return The output DTO (ProductOutDto) representing the created product.
	 */
	private ProductOutDto prepareOutDto(Product product) {
		ProductOutDto productOutDto = new ProductOutDto();
		productOutDto.setId(product.getProductId());
		productOutDto.setName(product.getName());
		productOutDto.setPrice(product.getPrice());
		productOutDto.setManufacturedBy(product.getManufacturedBy());
		productOutDto.setDiscount(product.getDiscount());
		productOutDto.setDescription(product.getDescription());
		productOutDto.setQuantity(product.getQuantity());
		return productOutDto;
	}

	/**
	 * Retrieves a product by its ID.
	 * @param productId The ID of the product to retrieve.
	 * @return The output DTO (ProductOutDto) representing the retrieved product.
	 * @throws ProductNotFoundException If the product with the given ID is not found.
	 */
	public ProductOutDto getProductById(int productId) throws ProductNotFoundException {
		Optional<Product> findById = productRepository.findById(productId);
		if (!findById.isPresent()) {
			throw new ProductNotFoundException("Product not found");
		}

		Product product = findById.get();
		return prepareOutDto(product);
	}

	/**
	 * Updates a product with the provided details.
	 * @param productInDto The input DTO containing the updated details of the product.
	 * @param productId The ID of the product to update.
	 * @return The output DTO (ProductOutDto) representing the updated product.
	 * @throws ProductNotFoundException If the product with the given ID is not found.
	 */
	public ProductOutDto getUpdateProductById(ProductInDto productInDto, int productId) throws ProductNotFoundException {
		Optional<Product> findById = productRepository.findById(productId);
		if (!findById.isPresent()) {
			throw new ProductNotFoundException("Product not found");
		}
		Product product = findById.get();
		product.setProductId(productInDto.getId());
		product.setName(productInDto.getName());
		product.setPrice(productInDto.getPrice());
		product.setManufacturedBy(productInDto.getManufacturedBy());
		product.setDiscount(productInDto.getDiscount());
		product.setDescription(productInDto.getDescription());
		product.setQuantity(productInDto.getQuantity());
		productRepository.save(product);
		return prepareOutDto(product);
	}

	/**
	 * Deletes a product by its ID.
	 * @param productId The ID of the product to delete.
	 * @throws ProductNotFoundException If the product with the given ID is not found.
	 */
	public void deleteProductById(int productId) throws ProductNotFoundException {
		Optional<Product> findById = productRepository.findById(productId);
		if (!findById.isPresent()) {
			throw new ProductNotFoundException("Product not found");
		}
		this.productRepository.deleteById(productId);
		
	}

}
