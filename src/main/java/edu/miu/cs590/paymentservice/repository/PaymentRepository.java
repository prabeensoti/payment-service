package edu.miu.cs590.paymentservice.repository;

import edu.miu.cs590.paymentservice.domain.OrderPayment;
import edu.miu.cs590.paymentservice.dto.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<OrderPayment,Long> {
    Payment findByPaymentId(Long paymentId);
}
