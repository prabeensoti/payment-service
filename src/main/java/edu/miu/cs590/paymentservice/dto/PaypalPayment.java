package edu.miu.cs590.paymentservice.dto;


import edu.miu.cs590.paymentservice.domain.PaymentTypes;
import lombok.Data;

@Data
public class PaypalPayment implements Payment {
    private String userId;
    private String paypalId;
    private Double balance;
    private PaymentTypes paymentTypes = PaymentTypes.PAYPAL;
    @Override
    public PaymentTypes getPaymentType() {
        return paymentTypes;
    }
}
