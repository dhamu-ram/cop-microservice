package io.com.order.api.ordermanagement.dao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import io.com.order.api.ordermanagement.model.Order;
import io.com.order.api.ordermanagement.service.OrderService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderRepositoryTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    public void testFindByBuyerId() {
        Long buyerId = 1L;
        List<Order> orders = new ArrayList<>();
        orders.add(new Order());
        orders.add(new Order());

        when(orderRepository.findByBuyerId(buyerId)).thenReturn(orders);

        List<Order> result = orderRepository.findByBuyerId(buyerId);

        assertEquals(orders, result);
        Mockito.verify(orderRepository).findByBuyerId(buyerId);
    }
}

