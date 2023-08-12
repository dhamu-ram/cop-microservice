package io.com.order.api.ordermanagement.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.com.order.api.ordermanagement.model.Order;

/**
 * The OrderRepository interface provides CRUD operations for managing orders in the database.
 * @author abhis
 */
public interface OrderRepository extends MongoRepository<Order, Long> {

    /**
     * Retrieves a list of orders by the buyer's identifier.
     * @param buyerId The identifier of the buyer.
     * @return A list of orders associated with the buyer.
     */
    List<Order> findByBuyerId(Long buyerId);
}

