package com.example.kiosk.order.entity;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor //클래스에 존재하는 모든 필드에 대한 생성자를 자동으로 생성해줍니다.
@NoArgsConstructor//파라미터가 없는 생성자 생성
@Builder
public class Payment {
    private  Long amount; //지불금액
    private String orderId; //주문 고유 ID
    private String method; //어떤 수단 -카드.계좌...
    private  String orderName; //주문 상품이름
    private  String successUrl; //콜밲_성공시
    private  String failUrl; //콜밲_성공시

    public Payment() { //랜덤아이디(중복방지)
        this.orderId = UUID.randomUUID().toString();
    }

    public  Payment
}
