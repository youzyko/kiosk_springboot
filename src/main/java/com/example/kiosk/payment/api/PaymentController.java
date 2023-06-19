package com.example.kiosk.payment.api;


import com.example.kiosk.payment.entity.Payment;
import com.example.kiosk.payment.service.PaymentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/payment")
@RequiredArgsConstructor
@CrossOrigin

public class PaymentController {
    private final PaymentService paymentService;
    @PostMapping
    public boolean approved(@RequestBody Payment payment ) {
        log.info("PAYMENT_CONTROLLER");
        Payment payment1=new Payment(payment);
        boolean b= paymentService.approved(payment1);
        return b;
    }

}
