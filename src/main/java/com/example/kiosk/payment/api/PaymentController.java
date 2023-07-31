package com.example.kiosk.payment.api;


import com.example.kiosk.payment.entity.Payment;
import com.example.kiosk.payment.service.PaymentService;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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


   @GetMapping("/{startDate}/{endDate}") //기록으로 매출조회
    public ResponseEntity<List<Payment>> searchList(
            @PathVariable String startDate,
            @PathVariable String endDate
    ) {
        log.info("PAYMENT_SEARCHALL_CONTROLLER");
        List<Payment> payments = paymentService.searchList(startDate, endDate);
        return ResponseEntity.ok().body(payments);
    }

     @GetMapping("/{orderCard}") //승인번호로 매출조회
    public  ResponseEntity<?> ordercardshow(@PathVariable int orderCard ){
        log.info("PAYMENT_ORDERCARDSHOW_CONTROLLER");

            return ResponseEntity.ok().body(paymentService.ordercardshow(orderCard));


    }

    @DeleteMapping("/{orderCard}") //승인번호로 삭제하기
    public ResponseEntity<?> delete(@PathVariable int orderCard){
        log.info("PAYMENT_DELETE_CONTROLLER");
        try {
            boolean f=paymentService.delete(orderCard);
            return  ResponseEntity.ok().body(f);
        }catch (RuntimeException e){
            return  ResponseEntity.notFound().build();

        }
    }


}//class_end
