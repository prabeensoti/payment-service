package edu.miu.cs590.paymentservice.service;


import edu.miu.cs590.paymentservice.dto.Payment;
import edu.miu.cs590.paymentservice.domain.PaymentStatus;

public interface PaymentService {

    PaymentStatus makePayment(String orderId, Payment payment);

//    PaymentStatus makePayment(PaypalPaymentMethod paymentMethod, String orderId, PaypalPayment payment);
}
