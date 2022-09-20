package edu.miu.cs590.paymentservice.clients.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class PayPalPaymentFeignConfig {
    @Value("${paypal.payment.secret.key}")
    public String serviceKey;

    @Bean
    public RequestInterceptor requestInterceptor(){
        return requestTemplate -> {
            requestTemplate.header("API_KEY", serviceKey);
        };
    }
}
