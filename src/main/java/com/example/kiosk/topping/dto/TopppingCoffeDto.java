package com.example.kiosk.topping.dto;

import com.example.kiosk.topping.entity.Toppping;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TopppingCoffeDto {
    private String toppingNameCoffee; //토핑이름

    private int toppingPriceCoffee; //토핑 가격

    public TopppingCoffeDto(Toppping toppping){
        this.toppingNameCoffee=toppping.getToppingNameCoffee();
        this.toppingPriceCoffee=toppping.getToppingPriceCoffee();


    }
}//class end
