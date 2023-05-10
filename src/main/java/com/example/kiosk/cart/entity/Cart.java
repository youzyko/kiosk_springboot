package com.example.kiosk.cart.entity;

import com.example.kiosk.item.entity.Item;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
//@NoArgsConstructor
@Builder
public class Cart {
  //  Item item;
    private int amount; //수량
    private  String hereTogo; //매장/포장
    private String hotIce;//핫/아이스
    private  String iceAmount; //얼음양
    private  int totalPrice; // 총합계

    public  Cart (Cart cart){
       // this.item=cart.getItem();
        this.amount=cart.getAmount();
        this.hereTogo=cart.getHereTogo();
        this.hotIce=cart.getHotIce();
        this.iceAmount=cart.getIceAmount();
        this.totalPrice=cart.getTotalPrice();

    }

}
