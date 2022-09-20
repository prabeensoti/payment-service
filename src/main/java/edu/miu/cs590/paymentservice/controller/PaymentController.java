package edu.miu.cs590.paymentservice.controller;

import edu.miu.cs590.paymentservice.domain.PaymentStatus;
import edu.miu.cs590.paymentservice.dto.BankPayment;
import edu.miu.cs590.paymentservice.dto.CCPayment;
import edu.miu.cs590.paymentservice.dto.PaypalPayment;
import edu.miu.cs590.paymentservice.dto.PaymentRequest;
import edu.miu.cs590.paymentservice.service.PaymentService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/paypal")
    public PaymentStatus processPaypal(@RequestBody PaymentRequest paymentRequest){
        PaypalPayment payment = new PaypalPayment();
        payment.setUserId(paymentRequest.getUserId());
        payment.setPaypalId(paymentRequest.getPaypalId());
        payment.setBalance(paymentRequest.getBalance());
        return paymentService.makePayment(paymentRequest.getOrderId(), payment);
    }

    @PostMapping("/cc")
    public PaymentStatus processCreditCard(@RequestBody PaymentRequest paymentRequest){
        CCPayment payment = new CCPayment();
        payment.setUserId(paymentRequest.getUserId());
        payment.setCreditCardNumber(paymentRequest.getCreditCardNumber());
        payment.setBalance(paymentRequest.getBalance());
        return paymentService.makePayment(paymentRequest.getOrderId(), payment);
    }

    @PostMapping("/bank")
    public PaymentStatus processBank(@RequestBody PaymentRequest paymentRequest){
        BankPayment payment = new BankPayment();
        payment.setUserId(paymentRequest.getUserId());
        payment.setBankAccNumber(paymentRequest.getBankAccNumber());
        payment.setBalance(paymentRequest.getBalance());

        return paymentService.makePayment(paymentRequest.getOrderId(), payment);
    }

}
