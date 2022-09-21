package edu.miu.cs590.paymentservice.clients;

import edu.miu.cs590.paymentservice.clients.config.PayPalPaymentFeignConfig;
import edu.miu.cs590.paymentservice.dto.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "paypal-payment-service", url = "${paypal.payment.url}", configuration = PayPalPaymentFeignConfig.class)
public interface PayPalPaymentFeignClient {
    @PostMapping("/process-payment")
    ResponseEntity<String> makePayment(@RequestBody Payment paypalPayment);
}
