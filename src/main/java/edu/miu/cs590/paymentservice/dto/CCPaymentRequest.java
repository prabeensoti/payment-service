package edu.miu.cs590.paymentservice.dto;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class CCPaymentRequest {
    @NotNull
    private String userId;
    @NotNull
    private String creditCardNumber;
    @NotNull
    private Double balance;
    @NotNull
    private String orderId;
}
