package io.com.product.api.productmanagement.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductInDtoTest {

    @Test
    public void testGetId() {
        ProductInDto product = new ProductInDto();
        product.setId(1L);
        assertEquals(1L, product.getId());
    }

    @Test
    public void testGetName() {
        ProductInDto product = new ProductInDto();
        product.setName("Product 1");
        assertEquals("Product 1", product.getName());
    }

    @Test
    public void testGetDescription() {
        ProductInDto product = new ProductInDto();
        product.setDescription("Description 1");
        assertEquals("Description 1", product.getDescription());
    }

    @Test
    public void testGetPrice() {
        ProductInDto product = new ProductInDto();
        product.setPrice(100.0);
        assertEquals(100.0, product.getPrice());
    }

    @Test
    public void testGetDiscount() {
        ProductInDto product = new ProductInDto();
        product.setDiscount(10.0);
        assertEquals(10.0, product.getDiscount());
    }

    @Test
    public void testGetManufacturedBy() {
        ProductInDto product = new ProductInDto();
        product.setManufacturedBy("Manufacturer 1");
        assertEquals("Manufacturer 1", product.getManufacturedBy());
    }

    @Test
    public void testGetQuantity() {
        ProductInDto product = new ProductInDto();
        product.setQuantity(10L);
        assertEquals(10L, product.getQuantity());
    }

    @Test
    public void testSetId() {
        ProductInDto product = new ProductInDto();
        product.setId(1L);
        assertEquals(1L, product.getId());
    }

    @Test
    public void testSetName() {
        ProductInDto product = new ProductInDto();
        product.setName("Product 1");
        assertEquals("Product 1", product.getName());
    }

    @Test
    public void testSetDescription() {
        ProductInDto product = new ProductInDto();
        product.setDescription("Description 1");
        assertEquals("Description 1", product.getDescription());
    }

    @Test
    public void testSetPrice() {
        ProductInDto product = new ProductInDto();
        product.setPrice(100.0);
        assertEquals(100.0, product.getPrice());
    }

    @Test
    public void testSetDiscount() {
        ProductInDto product = new ProductInDto();
        product.setDiscount(10.0);
        assertEquals(10.0, product.getDiscount());
    }

    @Test
    public void testSetManufacturedBy() {
        ProductInDto product = new ProductInDto();
        product.setManufacturedBy("Manufacturer 1");
        assertEquals("Manufacturer 1", product.getManufacturedBy());
    }

    @Test
    public void testSetQuantity() {
        ProductInDto product = new ProductInDto();
        product.setQuantity(10L);
        assertEquals(10L, product.getQuantity());
    }
    
    @Test
    public void testToString() {
        ProductInDto product = new ProductInDto();
        product.setId(1L);
        product.setName("Product 1");
        product.setDescription("Description 1");
        product.setPrice(100.0);
        product.setDiscount(10.0);
        product.setManufacturedBy("Manufacturer 1");
        product.setQuantity(10L);

        String expectedString = "ProductInDto(id=1, name=Product 1, description=Description 1, price=100.0, discount=10.0, manufacturedBy=Manufacturer 1, quantity=10)";
        assertEquals(expectedString, product.toString());
    }

    @Test
    public void testHashCode() {
        ProductInDto product1 = new ProductInDto();
        product1.setId(1L);

        ProductInDto product2 = new ProductInDto();
        product2.setId(1L);

        assertEquals(product1.hashCode(), product2.hashCode());
    }
}







