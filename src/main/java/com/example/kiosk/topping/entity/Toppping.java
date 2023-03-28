package com.example.kiosk.topping.entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Toppping {
    private int menuId;
    private int random; //허수
    private String toppingNameCoffee; //토핑이름

    private  int toppingPriceCoffee; //토핑 가격


    private String toppingNameNonCoffee; //논커피 토핑이름
    private int toppingPriceNonCoffee; //논커피 토핑 가격

    // String toppingImg; 토핑이미지


}
