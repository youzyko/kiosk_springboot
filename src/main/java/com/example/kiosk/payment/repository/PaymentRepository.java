package com.example.kiosk.payment.repository;

import com.example.kiosk.payment.entity.Payment;
import org.apache.ibatis.annotations.Mapper;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Mapper
public interface PaymentRepository {
    boolean approved(Payment payment);
    List<Payment> showAll();
    List<Payment> searchList(Date startDate, Date endDate);

    boolean delete(int orderCard);

    List<Payment> ordercardshow(int orderCard);
/*    List<Payment> searchList();*/
   /* List<Payment> searchList(LocalDate stareDate, LocalDate endDate);*/
}
