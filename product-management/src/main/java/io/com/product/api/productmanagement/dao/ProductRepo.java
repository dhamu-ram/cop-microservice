package io.com.product.api.productmanagement.dao;

import io.com.product.api.productmanagement.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductRepo extends MongoRepository<Product, Integer> {

}
