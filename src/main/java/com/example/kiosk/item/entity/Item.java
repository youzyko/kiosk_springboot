package com.example.kiosk.item.entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    private  int itemId; //상품아이디
    private String itemName; //상품 이름(PK)
    private  int itemPrice; //상품 가격
    private  String itemDetail; //상품 상세 내용
    private  int countNum; //수량
    private boolean status; //상품상태(판매중/품절)

    private String itemImg; //상품이미지
    private  String userId; //상품 등록한 자(admin)




}
