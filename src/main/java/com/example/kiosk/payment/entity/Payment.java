package com.example.kiosk.payment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
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
    private int  orderId; //주문번호
   // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date   date; //주문시간
    private  int  orderCard; //카드 승인번호
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate; //주문기간_시작
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate  endDate; //주문기간_시작


    public int orderCard() { //카드 승인 번호 (pk)
        Random random = new Random();
        return 10000000 + random.nextInt(90000000); //8자리 랜덤 카드 승인 번호
    }

    public Payment(Payment payment) {
       // this();
        this.orderId=payment.getOrderId();
        this.totalPrice = payment.getTotalPrice();
        this.orderName = payment.getOrderName();
        this.orderNameJson = payment.getOrderNameJson();
        this.orderTopping = payment.getOrderTopping();
        this.orderCard=payment.orderCard();
        this.endDate=payment.getEndDate();
        this.startDate=payment.getStartDate();
    }

   @Override
    public String toString() {
        return "Payment{" +
                "totalPrice=" + totalPrice +
                ", orderNameJson='" + orderNameJson + '\'' +
                ", orderTopping='" + orderTopping + '\'' +
              ", orderId='" + orderId + '\'' +
                ", date=" + date +
               ", endDate='" + endDate + '\'' +
                ", startDate='" + startDate + '\'' +

                '}';
    }


}//class_end

