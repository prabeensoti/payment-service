package edu.miu.cs590.paymentservice.dto;

import edu.miu.cs590.paymentservice.domain.PaymentTypes;
import lombok.Data;

@Data
public class CCPayment implements Payment {
    private String userId;
    private String creditCardNumber;
    private Double balance;
    private PaymentTypes paymentTypes = PaymentTypes.CC;

    @Override
    public PaymentTypes getPaymentType() {
        return paymentTypes;
    }
}
