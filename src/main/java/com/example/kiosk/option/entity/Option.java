package com.example.kiosk.option.entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Option {
    //select tag 사용할것
    private  String menuName; //음료이름(PK)
    private int menuId; // 1-밀크티 2-커피...
    private  int countNum; //수량
    //===================================================================
    private  int hereTogo; // 포장/매장
    private int hotCold; // hot/cold
    private int iceAmount; //얼음양 많이/중간/적게
    private int sweetness; //당도 달게/중간/덜달게
    private String topping; //토핑
    private int toppingPrice; //토핑가격
    private int coffeeTopping; // 샷추가
    private int shotPrice; // 샷추가 가격


}
