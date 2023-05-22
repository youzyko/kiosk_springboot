package com.example.kiosk.topping.entity;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
//@NoArgsConstructor
@Builder
public class Toppping {
    private int menuId; //menuId=3(커피)이면 다른 토핑 보여주기
    private int random; //허수
    private String toppingName; //토핑이름
    private  int toppingPrice; //토핑 가격
    private String toppingImg; //토핑이미지
    private String ownImgId; //이미지를 위한 id

    public Toppping() { //랜덤아이디(중복방지)
        this.ownImgId = UUID.randomUUID().toString();
    }

    public Toppping(Toppping toppping) {
        this();
        this.menuId=toppping.getMenuId();
        this.random=toppping.getRandom();
        this.toppingName=toppping.getToppingName();
        this.toppingPrice=toppping.getToppingPrice();
        this.toppingImg=toppping.getToppingImg();
    }
}
