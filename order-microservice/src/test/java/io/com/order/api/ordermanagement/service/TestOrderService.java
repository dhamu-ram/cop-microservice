package io.com.order.api.ordermanagement.service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.com.order.api.ordermanagement.dao.OrderRepository;
import io.com.order.api.ordermanagement.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TestOrderService {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private SequenceGenerator sequenceGenerator;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPlaceOrder() {
        Order order = new Order();
        order.setBuyerId(1L);
        List<String> products = new ArrayList<>();
        products.add("product1");
        products.add("product2");
        order.setProducts(products);

        when(sequenceGenerator.generateSequence(Order.SEQUENCE_NAME)).thenReturn(1L);
        when(orderRepository.save(order)).thenReturn(order);

        Order result = orderService.placeOrder(order);

        verify(sequenceGenerator).generateSequence(Order.SEQUENCE_NAME);
        verify(orderRepository).save(order);
        assertEquals(order, result);
    }

    @Test
    public void testCancelOrder() {
        Long orderId = 1L;
        orderService.cancelOrder(orderId);
        verify(orderRepository).deleteById(orderId);
    }

    @Test
    public void testGetOrdersByBuyerId() {
        Long buyerId = 1L;
        List<Order> orders = new ArrayList<>();
        orders.add(new Order());
        orders.add(new Order());

        when(orderRepository.findByBuyerId(buyerId)).thenReturn(orders);
        List<Order> result = orderService.getOrdersByBuyerId(buyerId);
        verify(orderRepository).findByBuyerId(buyerId);
        assertEquals(orders, result);
    }

    @Test
    public void testGetOrderById() {
        Long orderId = 1L;
        Order order = new Order();

        when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));
        Optional<Order> result = orderService.getOrderById(orderId);
        verify(orderRepository).findById(orderId);
        assertEquals(Optional.of(order), result);
    }
}
