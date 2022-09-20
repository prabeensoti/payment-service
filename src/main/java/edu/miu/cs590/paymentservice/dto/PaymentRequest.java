package edu.miu.cs590.paymentservice.dto;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class PaymentRequest {
    @NotNull
    private String userId;
    @NotNull
    private String bankAccNumber;
    @NotNull
    private Double balance;
    @NotNull
    private String orderId;
    @NotNull
    private String paypalId;
    @NotNull
    private String creditCardNumber;
}
