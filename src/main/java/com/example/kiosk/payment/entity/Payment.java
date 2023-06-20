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
@AllArgsConstructor //클래스에 존재하는 모든 필드에 대한 생성자를 자동으로 생성해줍니다.
//@NoArgsConstructor//파라미터가 없는 생성자 생성
@Builder
public class Payment {
    private int totalPrice; //총가격
    private List<String> orderName; //주문한 메뉴이름 list형태
    private  String orderNameJson; //list=>String 형태
    private String orderTopping; //주문 토핑
    private String orderId; //주문번호

    private Date date; //주문시간

    public Payment() { //랜덤아이디(중복방지)
        this.orderId = UUID.randomUUID().toString();
    }

    public Payment(Payment payment) {
        this();
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

