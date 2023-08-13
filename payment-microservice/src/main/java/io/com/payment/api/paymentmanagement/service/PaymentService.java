package io.com.payment.api.paymentmanagement.service;

import io.com.payment.api.paymentmanagement.dao.WalletRepository;
import io.com.payment.api.paymentmanagement.exception.InsufficientBalanceException;
import io.com.payment.api.paymentmanagement.exception.NotFoundException;
import io.com.payment.api.paymentmanagement.model.Wallet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    /**
     * The WalletRepository object.
     */
    @Autowired
    private WalletRepository walletRepository;

    /**
     * The Mongodb Template object.
     */
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * The SequenceGenerator object.
     */
    @Autowired
    private SequenceGenerator sequenceGenerator;

    /**
     * The Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentService.class);

    /** This method is used to add wallet details into database.
     * @param wallet - wallet details.
     * @return the added wallet details.
     */
    public Wallet addWallet(Wallet wallet) {
        wallet.setId(sequenceGenerator.generateSequence(Wallet.SEQUENCE_NAME));
        return walletRepository.save(wallet);
    }

    public void deleteWallet(Long walletId) throws NotFoundException {
        Optional<Wallet> wallet = walletRepository.findById(walletId);
        if(wallet.isEmpty()) {
            throw new NotFoundException(String.format("wallet is not found for id ", walletId));
        }
        walletRepository.deleteById(walletId);
    }

    public String makePayment(Long walletId, double amount) throws InsufficientBalanceException {
        Optional<Wallet> wallet = walletRepository.findById(walletId);

        double newBalance = 0;

        if(wallet.isPresent()) {
            double balance = wallet.get().getBalance();

            if (balance < amount) {
                LOGGER.error("Insufficient balance in the wallet");
                throw new InsufficientBalanceException("Insufficient balance in the wallet");
            }

            newBalance = balance - amount;
            wallet.get().setBalance(newBalance);
            walletRepository.save(wallet.get());
        }

        return String.format("Payment done successfully. Balance in your account is %s", newBalance);
    }

    public Wallet setDefaultWallet(Long walletId, Long userId) {
        Query query = new Query(Criteria.where("userId").is(userId).and("isDefault").is(false));
        Optional<Wallet> defaultWallet = Optional.ofNullable(mongoTemplate.findOne(query, Wallet.class));

        if (defaultWallet.isPresent()) {
            defaultWallet.get().setIsDefault(true);
            defaultWallet.get().setId(walletId);
        }

        return walletRepository.save(defaultWallet.get());
    }

}
