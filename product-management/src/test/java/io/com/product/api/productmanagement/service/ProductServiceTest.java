package io.com.product.api.productmanagement.service;

import io.com.product.api.productmanagement.dao.ProductRepo;
import io.com.product.api.productmanagement.dto.ProductInDto;
import io.com.product.api.productmanagement.dto.ProductOutDto;
import io.com.product.api.productmanagement.exception.ProductNotFoundException;
import io.com.product.api.productmanagement.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

	@InjectMocks
	private ProductService productService;

	@Mock
	private ProductRepo productRepository;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testCreateProduct() {
		Long id = 1L;
		String name = "Samsung Galaxy";
		String description = "Smartphone";
		Double price = 1000.0;
		Double discount = 100.0;
		String manufacturedBy = "Samsung";
		Long quantity = 10L;

		ProductInDto productInDto = new ProductInDto();
		productInDto.setId(id);
		productInDto.setName(name);
		productInDto.setDescription(description);
		productInDto.setPrice(price);
		productInDto.setDiscount(discount);
		productInDto.setManufacturedBy(manufacturedBy);
		productInDto.setQuantity(quantity);

		Product product = new Product();
		product.setProductId(id);
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		product.setDiscount(discount);
		product.setManufacturedBy(manufacturedBy);
		product.setQuantity(quantity);

		when(productRepository.save(any(Product.class))).thenReturn(product);

		ProductOutDto productOutDto = productService.createProduct(productInDto);

		assertEquals(id, productOutDto.getId());
		assertEquals(name, productOutDto.getName());
		assertEquals(description, productOutDto.getDescription());
		assertEquals(price, productOutDto.getPrice());
		assertEquals(discount, productOutDto.getDiscount());
		assertEquals(manufacturedBy, productOutDto.getManufacturedBy());
		assertEquals(quantity, productOutDto.getQuantity());

		verify(productRepository, times(1)).save(any(Product.class));
	}

	@Test
	public void testGetProductById() throws ProductNotFoundException {
		Long id = 1L;
		String name = "Samsung Galaxy";
		String description = "Smartphone";
		Double price = 1000.0;
		Double discount = 100.0;
		String manufacturedBy = "Samsung";
		Long quantity = 10L;

		Product product = new Product();
		product.setProductId(id);
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		product.setDiscount(discount);
		product.setManufacturedBy(manufacturedBy);
		product.setQuantity(quantity);

		when(productRepository.findById(id.intValue())).thenReturn(Optional.of(product));

		ProductOutDto productOutDto = productService.getProductById(id.intValue());

		assertEquals(id, productOutDto.getId());
		assertEquals(name, productOutDto.getName());
		assertEquals(description, productOutDto.getDescription());
		assertEquals(price, productOutDto.getPrice());
		assertEquals(discount, productOutDto.getDiscount());
		assertEquals(manufacturedBy, productOutDto.getManufacturedBy());
		assertEquals(quantity, productOutDto.getQuantity());

		verify(productRepository, times(1)).findById(1);
	}

	@Test
	public void testGetProductById_ProductNotFound() {
		Long id = 1L;

		when(productRepository.findById(id.intValue())).thenReturn(Optional.empty());

		assertThrows(ProductNotFoundException.class, () -> {
			productService.getProductById(id.intValue());
		});

		verify(productRepository, times(1)).findById(id.intValue());
	}

	@Test
	public void testGetUpdateProductById() throws ProductNotFoundException {
		Long id = 1L;
		String name = "Samsung Galaxy";
		String description = "Smartphone";
		Double price = 1000.0;
		Double discount = 100.0;
		String manufacturedBy = "Samsung";
		Long quantity = 10L;

		ProductInDto productInDto = new ProductInDto();
		productInDto.setId(id);
		productInDto.setName(name);
		productInDto.setDescription(description);
		productInDto.setPrice(price);
		productInDto.setDiscount(discount);
		productInDto.setManufacturedBy(manufacturedBy);
		productInDto.setQuantity(quantity);

		Product product = new Product();
		product.setProductId(id);
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		product.setDiscount(discount);
		product.setManufacturedBy(manufacturedBy);
		product.setQuantity(quantity);

		when(productRepository.findById(id.intValue())).thenReturn(Optional.of(product));
		when(productRepository.save(any(Product.class))).thenReturn(product);

		ProductOutDto productOutDto = productService.getUpdateProductById(productInDto, id.intValue());

		assertEquals(id, productOutDto.getId());
		assertEquals(name, productOutDto.getName());
		assertEquals(description, productOutDto.getDescription());
		assertEquals(price, productOutDto.getPrice());
		assertEquals(discount, productOutDto.getDiscount());
		assertEquals(manufacturedBy, productOutDto.getManufacturedBy());
		assertEquals(quantity, productOutDto.getQuantity());

		verify(productRepository, times(1)).findById(id.intValue());
		verify(productRepository, times(1)).save(any(Product.class));
	}

	@Test
	public void testGetUpdateProductById_ProductNotFound() {
		Long id = 1L;
		ProductInDto productInDto = new ProductInDto();

		when(productRepository.findById(id.intValue())).thenReturn(Optional.empty());

		assertThrows(ProductNotFoundException.class, () -> {
			productService.getUpdateProductById(productInDto, id.intValue());
		});

		verify(productRepository, times(1)).findById(id.intValue());
	}

	@Test
	public void testDeleteProductById() throws ProductNotFoundException {
		Long id = 1L;

		when(productRepository.findById(id.intValue())).thenReturn(Optional.of(new Product()));

		assertDoesNotThrow(() -> {
			productService.deleteProductById(id.intValue());
		});

		verify(productRepository, times(1)).findById(id.intValue());
		verify(productRepository, times(1)).deleteById(id.intValue());
	}

	@Test
	public void testDeleteProductById_ProductNotFound() {
		Long id = 1L;

		when(productRepository.findById(id.intValue())).thenReturn(Optional.empty());

		assertThrows(ProductNotFoundException.class, () -> {
			productService.deleteProductById(id.intValue());
		});

		verify(productRepository, times(1)).findById(id.intValue());
	}
}

