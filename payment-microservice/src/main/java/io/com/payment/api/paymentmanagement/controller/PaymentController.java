package io.com.payment.api.paymentmanagement.controller;

import io.com.payment.api.paymentmanagement.dto.PaymentRequestDTO;
import io.com.payment.api.paymentmanagement.exception.InsufficientBalanceException;
import io.com.payment.api.paymentmanagement.exception.NotFoundException;
import io.com.payment.api.paymentmanagement.model.Wallet;
import io.com.payment.api.paymentmanagement.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/** This class contains the api endpoints related to payment service.
 * @author abhis
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    /**
     * The paymentService object.
     */
    @Autowired
    private PaymentService paymentService;

    /**
     * The Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

    @PostMapping("/wallet")
    public Wallet addWallet(@RequestBody Wallet wallet) {
        LOGGER.info("Request received to add wallet for {}", wallet);
        Wallet addedWallet = paymentService.addWallet(wallet);
        LOGGER.info("Successfully added wallet for {}", wallet);
        return addedWallet;
    }

    @DeleteMapping("/wallet/{walletId}")
    public String deleteWallet(@PathVariable Long walletId) throws NotFoundException {
        LOGGER.info("Request received to delete wallet for {}", walletId);
        paymentService.deleteWallet(walletId);
        String response = String.format("Wallet details removed successfully for %d", walletId);
        return response;
    }

    @PostMapping("/{walletId}")
    public String makePayment(@PathVariable Long walletId, @RequestBody PaymentRequestDTO paymentRequestDTO) throws InsufficientBalanceException {
        LOGGER.info("Request received to make payment for {}", paymentRequestDTO.toString());
        String response = paymentService.makePayment(walletId, paymentRequestDTO.getAmount());
        LOGGER.info("Successfully payment done for {}", paymentRequestDTO.toString());
        return response;
    }

    @PutMapping("/wallet/{walletId}/default/{userId}")
    public Wallet setDefaultWallet(@PathVariable Long walletId, @PathVariable Long userId) {
        LOGGER.info("Request recieved to set wallet as default for {}", walletId);
        Wallet defaultWallet = paymentService.setDefaultWallet(walletId, userId);
        LOGGER.info("Successfully set wallet as default payment mode");
        return defaultWallet;
    }
}

