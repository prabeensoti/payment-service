package edu.miu.cs590.paymentservice.clients;

import edu.miu.cs590.paymentservice.clients.config.BankPaymentFeignConfig;
import edu.miu.cs590.paymentservice.dto.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "bank-payment-service", url = "${bank.payment.url}", configuration = BankPaymentFeignConfig.class)
public interface BankPaymentFeignClient {
    @PostMapping("/process-payment")
    ResponseEntity<String> makePayment(@RequestBody Payment paypalPayment);
}
