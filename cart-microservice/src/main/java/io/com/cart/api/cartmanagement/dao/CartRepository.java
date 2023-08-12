package io.com.cart.api.cartmanagement.dao;

import io.com.cart.api.cartmanagement.model.CartItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<CartItem, Long> {

}
