package io.com.product.api.productmanagement.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductOutDtoTest {

    @Test
    public void testSetAndGetId() {
        ProductOutDto product = new ProductOutDto();
        Long expectedId = 1L;
        product.setId(expectedId);

        Long actualId = product.getId();

        assertEquals(expectedId, actualId);
    }

    @Test
    public void testSetAndGetName() {
        ProductOutDto product = new ProductOutDto();
        String expectedName = "Product 1";
        product.setName(expectedName);

        String actualName = product.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void testSetAndGetDescription() {
        ProductOutDto product = new ProductOutDto();
        String expectedDescription = "Product description";
        product.setDescription(expectedDescription);

        String actualDescription = product.getDescription();

        assertEquals(expectedDescription, actualDescription);
    }

    @Test
    public void testSetAndGetPrice() {
        ProductOutDto product = new ProductOutDto();
        Double expectedPrice = 99.99;
        product.setPrice(expectedPrice);

        Double actualPrice = product.getPrice();

        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testSetAndGetDiscount() {
        ProductOutDto product = new ProductOutDto();
        Double expectedDiscount = 10.0;
        product.setDiscount(expectedDiscount);

        Double actualDiscount = product.getDiscount();

        assertEquals(expectedDiscount, actualDiscount);
    }

    @Test
    public void testSetAndGetManufacturedBy() {
        ProductOutDto product = new ProductOutDto();
        String expectedManufacturedBy = "Manufacturer";
        product.setManufacturedBy(expectedManufacturedBy);

        String actualManufacturedBy = product.getManufacturedBy();

        assertEquals(expectedManufacturedBy, actualManufacturedBy);
    }

    @Test
    public void testSetAndGetQuantity() {
        ProductOutDto product = new ProductOutDto();
        Long expectedQuantity = 100L;
        product.setQuantity(expectedQuantity);

        Long actualQuantity = product.getQuantity();

        assertEquals(expectedQuantity, actualQuantity);
    }

    @Test
    public void testToString() {
        ProductOutDto product = new ProductOutDto();
        product.setId(1L);
        product.setName("Product 1");
        product.setDescription("Product description");
        product.setPrice(99.99);
        product.setDiscount(10.0);
        product.setManufacturedBy("Manufacturer");
        product.setQuantity(100L);

        String expectedToString = "ProductOutDto(id=1, name=Product 1, description=Product description, price=99.99, discount=10.0, manufacturedBy=Manufacturer, quantity=100)";
        String actualToString = product.toString();

        assertEquals(expectedToString, actualToString);
    }

    @Test
    public void testEqualsAndHashCode() {
        ProductOutDto product1 = new ProductOutDto();
        product1.setId(1L);
        product1.setName("Product 1");
        product1.setDescription("Product description");
        product1.setPrice(99.99);
        product1.setDiscount(10.0);
        product1.setManufacturedBy("Manufacturer");
        product1.setQuantity(100L);

        ProductOutDto product2 = new ProductOutDto();
        product2.setId(1L);
        product2.setName("Product 1");
        product2.setDescription("Product description");
        product2.setPrice(99.99);
        product2.setDiscount(10.0);
        product2.setManufacturedBy("Manufacturer");
        product2.setQuantity(100L);

        assertEquals(product1, product2);
        assertEquals(product1.hashCode(), product2.hashCode());
    }
}
