package com.example.kiosk.payment.repository;

import com.example.kiosk.cart.entity.Cart;
import com.example.kiosk.payment.entity.Payment;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface PaymentRepository {
    boolean approved(Payment payment);
    List<Payment> showAll();
}
