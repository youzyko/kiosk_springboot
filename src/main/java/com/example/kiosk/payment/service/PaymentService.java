package com.example.kiosk.payment.service;

import com.example.kiosk.menu.entity.MenuName;
import com.example.kiosk.payment.entity.Payment;
import com.example.kiosk.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentService{
    private final PaymentRepository paymentRepository;
    public boolean approved(Payment payment) {
        log.info("PAYMENT_SERIVCE");
        return  paymentRepository.approved(payment);

    }




}
