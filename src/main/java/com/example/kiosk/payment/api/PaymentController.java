package com.example.kiosk.payment.api;


import com.example.kiosk.payment.entity.Payment;
import com.example.kiosk.payment.service.PaymentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/payment")
@RequiredArgsConstructor
@CrossOrigin

public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping//매출테이블에 추가
    public boolean approved(@RequestBody Payment payment) {
        log.info("PAYMENT_CONTROLLER");
        Payment payment1 = new Payment(payment);
        boolean b = paymentService.approved(payment1);
        return b;
    }

    @GetMapping
    public  ResponseEntity<?> showall(){
        log.info("PAYMENT_SHOWALL_CONTROLLER");
        return ResponseEntity.ok().body(paymentService.showAll());
    }

}//class_end
