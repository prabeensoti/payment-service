package edu.miu.cs590.paymentservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class PaymentServiceMVCConfigurer implements WebMvcConfigurer {
    @Autowired
    private PaymentServiceInterceptor paymentServiceInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(paymentServiceInterceptor);
    }
}
