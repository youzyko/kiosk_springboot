package com.example.kiosk.cart.entity;

import com.example.kiosk.item.entity.Item;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {

    //private int amount; //수량
    private  String here; //매장/포장
    private String hot;//핫/아이스
    private  String ice; //얼음양
    private  String itemName; //상품명
    private  int itemPrice; //가격
    private  String ownImgId; //이미지 id
    private  String itemImg; //이미지


   // private  int totalPrice; // 총합계*/
  //  private  String option;

  public  Cart (Cart cart){
       // this.option=cart.getOption();
       // this.item=cart.getItem();
      //  this.amount=cart.getAmount();
        this.here=cart.getHere();
        this.hot=cart.getHot();
        this.ice=cart.getIce();
        this.itemName= cart.getItemName();
        this.itemPrice=cart.getItemPrice();
      this.itemImg=cart.getItemImg();
      //  this.totalPrice=cart.getTotalPrice();

    }

}
