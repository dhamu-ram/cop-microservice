package io.com.payment.api.paymentmanagement.dao;

import io.com.payment.api.paymentmanagement.model.Wallet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WalletRepository extends MongoRepository<Wallet, Long>{

}
