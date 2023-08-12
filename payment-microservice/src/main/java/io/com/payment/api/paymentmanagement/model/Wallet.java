package io.com.payment.api.paymentmanagement.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Document(collection = "wallets")
public class Wallet {

    @Transient
    public static final String SEQUENCE_NAME = "wallet_sequence";

    @Id
    private Long id;
    private Long userId;
    private String cardNumber;
    private Double balance;
    private Boolean isDefault;
}