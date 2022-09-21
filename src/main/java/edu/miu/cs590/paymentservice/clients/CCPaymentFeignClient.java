package edu.miu.cs590.paymentservice.clients;

import edu.miu.cs590.paymentservice.clients.config.CCPaymentFeignConfig;
import edu.miu.cs590.paymentservice.dto.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "cc-payment-service", url = "${cc.payment.url}", configuration = CCPaymentFeignConfig.class)
public interface CCPaymentFeignClient {

    @PostMapping("/process-payment")
    ResponseEntity<String> makePayment(@RequestBody Payment paypalPayment);
}
