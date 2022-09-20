package edu.miu.cs590.paymentservice.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class OrderPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private String uuid;
    private PaymentTypes paymentType;
    private PaymentStatus status;
    private String orderId;
    private String transactionId;

    public OrderPayment(){
        if(uuid == null){
            this.uuid = UUID.randomUUID().toString();
        }
    }

}
