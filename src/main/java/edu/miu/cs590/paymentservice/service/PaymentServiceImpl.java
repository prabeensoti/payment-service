package edu.miu.cs590.paymentservice.service;

import edu.miu.cs590.paymentservice.domain.*;
import edu.miu.cs590.paymentservice.clients.CCPaymentFeignClient;
import edu.miu.cs590.paymentservice.dto.Payment;
import edu.miu.cs590.paymentservice.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    CCPaymentFeignClient paymentProxy;

    @Autowired
    PaymentRepository paymentRepository;


    @Override
    public PaymentStatus makePayment(String orderId, Payment payment) {

        ResponseEntity<String> response = paymentProxy.makePayment(payment);

        if(response.getStatusCode() != HttpStatus.OK){
            return PaymentStatus.ERROR;
        }
        OrderPayment orderPayment = new OrderPayment();
        orderPayment.setPaymentType(payment.getPaymentType());
        orderPayment.setOrderId(orderId);
        orderPayment.setStatus(PaymentStatus.SUCCESS);
        orderPayment.setTransactionId(response.getBody());

        paymentRepository.save(orderPayment);
        log.info("Payment Processed and saved!");
        return PaymentStatus.SUCCESS;
    }


}
