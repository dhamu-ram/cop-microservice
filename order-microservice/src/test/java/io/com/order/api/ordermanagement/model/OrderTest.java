package io.com.order.api.ordermanagement.model;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class OrderTest {

    @Test
    public void testGetterAndSetter() {
        Long id = 1L;
        Long buyerId = 2L;
        List<String> products = Arrays.asList("samsung", "oppo");

        Order order = new Order();
        order.setId(id);
        order.setBuyerId(buyerId);
        order.setProducts(products);

        assertEquals(id, order.getId());
        assertEquals(buyerId, order.getBuyerId());
        assertEquals(products, order.getProducts());
    }

    @Test
    public void testEqualsAndHashCode() {
        Long id = 1L;
        Long buyerId = 2L;
        List<String> products = Arrays.asList("samsung", "oppo");

        Order order1 = new Order();
        order1.setId(id);
        order1.setBuyerId(buyerId);
        order1.setProducts(products);

        Order order2 = new Order();
        order2.setId(id);
        order2.setBuyerId(buyerId);
        order2.setProducts(products);

        Order order3 = new Order();
        order3.setId(3L);
        order3.setBuyerId(4L);
        order3.setProducts(Arrays.asList("iphone", "huawei"));

        assertEquals(order1, order2);
        assertEquals(order1.hashCode(), order2.hashCode());

        assertNotEquals(order1, order3);
        assertNotEquals(order1.hashCode(), order3.hashCode());
    }

    @Test
    public void testToString() {
        Long id = 1L;
        Long buyerId = 2L;
        List<String> products = Arrays.asList("samsung", "oppo");

        Order order = new Order();
        order.setId(id);
        order.setBuyerId(buyerId);
        order.setProducts(products);

        String toStringResult = order.toString();

        String expectedToString = "Order(id=1, buyerId=2, products=[samsung, oppo])";
        assertEquals(expectedToString, toStringResult);
    }
}

