package com.example.kiosk.topping.dto;

import com.example.kiosk.topping.entity.Toppping;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TopppingNonCoffeDto {
    private String toppingNameNonCoffee; //논커피 토핑이름

    private int toppingPriceNonCoffee; //토핑 가격

    public TopppingNonCoffeDto(Toppping toppping){
        this.toppingNameNonCoffee=toppping.getToppingNameNonCoffee();
        this.toppingPriceNonCoffee=toppping.getToppingPriceNonCoffee();
    }
}//class end
