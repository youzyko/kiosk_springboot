package com.example.kiosk.payment.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.*;

import java.lang.reflect.Type;
import java.util.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {
    private int totalPrice; //총가격
    private List<String> orderName; //주문한 메뉴이름 list형태
    private  String orderNameJson; //list=>String 형태
    private String orderTopping; //주문 토핑
    private int  orderId; //주문번호 (pk)
    private Date date; //주문시간



    public Payment(Payment payment) {
        //this();
        this.orderId=payment.getOrderId();
        this.totalPrice = payment.getTotalPrice();
        this.orderName = payment.getOrderName();
        this.orderNameJson = payment.getOrderNameJson();
        this.orderTopping = payment.getOrderTopping();
    }

   @Override
    public String toString() {
        return "Payment{" +
                "totalPrice=" + totalPrice +
                ", orderNameJson='" + orderNameJson + '\'' +
                ", orderTopping='" + orderTopping + '\'' +
              ", orderId='" + orderId + '\'' +
                ", date=" + date +
                '}';
    }


}//class_end

