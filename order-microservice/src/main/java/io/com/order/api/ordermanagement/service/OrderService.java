package io.com.order.api.ordermanagement.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.com.order.api.ordermanagement.controller.OrderController;
import io.com.order.api.ordermanagement.dao.OrderRepository;
import io.com.order.api.ordermanagement.model.Order;


@Service
/**
 * The OrderService class provides methods for managing orders.
 * @author abhis
 */
public class OrderService {

    /**
     * The order repository for accessing order data.
     */
    @Autowired
    private OrderRepository orderRepository;

    /**
     * The sequence generator for generating unique order IDs.
     */
    @Autowired
    private SequenceGenerator sequenceGenerator;
    
    /**
     * The logger object for creating system logs.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);


    /**
     * Places an order and assigns a unique ID to it.
     * @param order The order to be placed.
     * @return The placed order.
     */
    public Order placeOrder(Order order) {
        order.setId(sequenceGenerator.generateSequence(order.SEQUENCE_NAME));
        return orderRepository.save(order);
    }

    /**
     * Cancels an order by its ID.
     * @param orderId The ID of the order to be canceled.
     */
    public void cancelOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    /**
     * Retrieves all orders for a given buyer ID.
     * @param buyerId The ID of the buyer.
     * @return A list of orders associated with the buyer ID.
     */
    public List<Order> getOrdersByBuyerId(Long buyerId) {
        return orderRepository.findByBuyerId(buyerId);
    }

    /**
     * Retrieves an order by its ID.
     * @param orderId The ID of the order to be retrieved.
     * @return An optional containing the order, or an empty optional if the order is not found.
     */
    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }
}

