package com.example.kiosk.cart.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Toppingcart {

    private String toppingName; //토핑 이름
    private  int toppingPrice; //토핑 가격

    public  Toppingcart (Toppingcart toppingcart){
        this.toppingName= toppingcart.getToppingName();
        this.toppingPrice=toppingcart.getToppingPrice();
    }

}
