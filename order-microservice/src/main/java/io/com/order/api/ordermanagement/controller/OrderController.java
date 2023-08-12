package io.com.order.api.ordermanagement.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.com.order.api.ordermanagement.model.Order;
import io.com.order.api.ordermanagement.service.OrderService;

/**
 * The OrderController class handles HTTP requests related to orders.
 * @author abhis
 */
@RestController
public class OrderController {

    /**
     * order service.
     */
    @Autowired
    private OrderService orderService;
    
    /**
     * The logger object for creating system logs.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    /**
     * Places an order.
     * @param order The order to be placed.
     * @return The placed order.
     */
    @PostMapping("/placeOrder")
    public Order placeOrder(@RequestBody Order order) {
        LOGGER.info("Placing an order");
        return orderService.placeOrder(order);
    }

    /**
     * Cancels an order by its identifier.
     * @param orderId The identifier of the order to be canceled.
     * @return A success message indicating that the order has been deleted.
     */
    @DeleteMapping("/{orderId}")
    public String cancelOrder(@PathVariable Long orderId) {
    	LOGGER.info("Canceling order with ID: {}", orderId);
        orderService.cancelOrder(orderId);
        return "Order deleted successfully for " + orderId;
    }

    /**
     * Retrieves a list of orders by the buyer's identifier.
     * @param buyerId The identifier of the buyer.
     * @return A list of orders associated with the buyer.
     */
    @GetMapping("/buyer/{buyerId}")
    public List<Order> getOrdersByBuyerId(@PathVariable Long buyerId) {
    	LOGGER.info("Retrieving orders for buyer with ID: {}", buyerId);
        return orderService.getOrdersByBuyerId(buyerId);
    }

    /**
     * Retrieves an order by its identifier.
     * @param orderId The identifier of the order.
     * @return The order if found, or a not found response.
     */
    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
    	LOGGER.info("Retrieving order with ID: {}", orderId);
        Optional<Order> order = orderService.getOrderById(orderId);
        return order.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
