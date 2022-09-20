package edu.miu.cs590.paymentservice.dto;

import edu.miu.cs590.paymentservice.domain.PaymentTypes;
import lombok.Data;

@Data
public class BankPayment implements Payment {
    private String userId;
    private String bankAccNumber;
    private Double balance;
    private PaymentTypes paymentTypes = PaymentTypes.BANK;

    @Override
    public PaymentTypes getPaymentType() {
        return paymentTypes;
    }
}
