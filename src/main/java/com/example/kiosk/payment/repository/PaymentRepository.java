package com.example.kiosk.payment.repository;

import com.example.kiosk.payment.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentRepository {
    boolean approved(Payment payment);
}
