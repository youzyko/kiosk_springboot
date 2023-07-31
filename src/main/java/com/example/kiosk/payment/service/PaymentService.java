package com.example.kiosk.payment.service;

import com.example.kiosk.payment.entity.Payment;
import com.example.kiosk.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public boolean approved(Payment payment) {
        log.info("PAYMENT_SERIVCE");
        return paymentRepository.approved(payment);

    }


    public List<Payment> showAll() { //전체항목
        log.info("PAYMENT_SHOWALL_SERVICE");
        return paymentRepository.showAll();
    }


    /*  public List<Payment> searchList(){ //전체항목
           log.info("PAYMENT_SERACH_SERVICE");
           return paymentRepository.searchList();
       }*/
    public List<Payment> searchList(String startDateStr, String endDateStr) {
        log.info("PAYMENT_SERACH_SERVICE");

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date startDate = dateFormat.parse(startDateStr); /* 문자열을 "yyyy-MM-dd"로 해석*/
            Date endDate = dateFormat.parse(endDateStr);


            endDate.setTime(endDate.getTime() + 24 * 60 * 60 * 1000);/*마지막 날 끝까지 포함시킴*/

            return paymentRepository.searchList(startDate, endDate);
        } catch (ParseException e) {
            log.error("Error parsing date strings: {}", e.getMessage());
            return null;
        }

    }


    public List<Payment> ordercardshow(int orderCard) { //전체항목
        log.info("PAYMENT_ORDERCARDSHOW_SERVICE");
        return paymentRepository.ordercardshow(orderCard);
    }

    public boolean delete(int orderCard){
        log.info("PAYMENT_DELETE_SERVICE");
        return paymentRepository.delete(orderCard);
    }
}//class_end
