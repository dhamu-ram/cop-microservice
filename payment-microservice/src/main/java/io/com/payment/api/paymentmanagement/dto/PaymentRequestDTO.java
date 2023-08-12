package io.com.payment.api.paymentmanagement.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PaymentRequestDTO {

    private Double amount;
}
