package io.com.product.api.productmanagement.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

	@Test
	public void testSetAndGetProductId() {
		Product product = new Product();
		Long productId = 1L;
		product.setProductId(productId);
		assertEquals(productId, product.getProductId());
	}

	@Test
	public void testSetAndGetName() {
		Product product = new Product();
		String name = "Product 1";
		product.setName(name);
		assertEquals(name, product.getName());
	}

	@Test
	public void testSetAndGetDescription() {
		Product product = new Product();
		String description = "Product Description";
		product.setDescription(description);
		assertEquals(description, product.getDescription());
	}

	@Test
	public void testSetAndGetQuantity() {
		Product product = new Product();
		Long quantity = 10L;
		product.setQuantity(quantity);
		assertEquals(quantity, product.getQuantity());
	}

	@Test
	public void testSetAndGetPrice() {
		Product product = new Product();
		double price = 100.0;
		product.setPrice(price);
		assertEquals(price, product.getPrice());
	}

	@Test
	public void testSetAndGetManufacturedBy() {
		Product product = new Product();
		String manufacturedBy = "Manufacturer";
		product.setManufacturedBy(manufacturedBy);
		assertEquals(manufacturedBy, product.getManufacturedBy());
	}

	@Test
	public void testSetAndGetDiscount() {
		Product product = new Product();
		double discount = 10.0;
		product.setDiscount(discount);
		assertEquals(discount, product.getDiscount());
	}

	@Test
	public void testEqualsAndHashCode() {
		Product product1 = new Product(1L, "Product 1", "Description 1", 10L, 100.0, "Manufacturer 1", 10.0);
		Product product2 = new Product(1L, "Product 1", "Description 1", 10L, 100.0, "Manufacturer 1", 10.0);
		Product product3 = new Product(2L, "Product 2", "Description 2", 20L, 200.0, "Manufacturer 2", 20.0);

		assertEquals(product1, product2);
		assertNotEquals(product1, product3);

		assertEquals(product1.hashCode(), product2.hashCode());
		assertNotEquals(product1.hashCode(), product3.hashCode());
	}

	@Test
	public void testAllArgsConstructor() {
		Long productId = 1L;
		String name = "Product 1";
		String description = "Description 1";
		Long quantity = 10L;
		double price = 100.0;
		String manufacturedBy = "Manufacturer 1";
		double discount = 10.0;

		Product product = new Product(productId, name, description, quantity, price, manufacturedBy, discount);

		assertEquals(productId, product.getProductId());
		assertEquals(name, product.getName());
		assertEquals(description, product.getDescription());
		assertEquals(quantity, product.getQuantity());
		assertEquals(price, product.getPrice());
		assertEquals(manufacturedBy, product.getManufacturedBy());
		assertEquals(discount, product.getDiscount());
	}

	@Test
	public void testNoArgsConstructor() {
		Product product = new Product();

		assertNull(product.getProductId());
		assertNull(product.getName());
		assertNull(product.getDescription());
		assertNull(product.getQuantity());
		assertEquals(0.0, product.getPrice());
		assertNull(product.getManufacturedBy());
		assertEquals(0.0, product.getDiscount());
	}

	@Test
    public void testToString() {
        Long productId = 1L;
        String name = "Product 1";
        String description = "Description 1";
        Long quantity = 10L;
        double price = 100.0;
        String manufacturedBy = "Manufacturer 1";
        double discount = 10.0;

        Product product = new Product(productId, name, description, quantity, price, manufacturedBy, discount);

        String expectedToString = "Product(productId=1, name=Product 1, description=Description 1, quantity=10, price=100.0, manufacturedBy=Manufacturer 1, discount=10.0)";
        String actualToString = product.toString();
        System.out.println(actualToString);
        assertEquals(expectedToString, actualToString);
    }


}

