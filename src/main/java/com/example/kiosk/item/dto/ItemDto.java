package com.example.kiosk.item.dto;

import com.example.kiosk.item.entity.Item;
import com.example.kiosk.menu.entity.MenuName;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {  //userId제외한 나머지
  //  MenuName menuName=new MenuName();

    private  int itemId; //상품아이디
    private String itemName; //상품 이름(PK)
    private  int itemPrice; //상품 가격
    //private  int countNum; //수량
    private boolean status; //상품상태(판매중/품절)
   // private  String itemDetail; //상품 상세 내용
    private String itemImg; //상품이미지
    private String ownImgId;

    public  ItemDto(Item item){
        this.itemId=item.getItemId();
        this.itemName=item.getItemName();
        this.itemPrice=item.getItemPrice();
       // this.countNum=item.getCountNum();
        this.status=item.isStatus();
        //this.itemDetail=item.getItemDetail();
       this.itemImg=item.getItemImg();
        this.ownImgId=item.getOwnImgId();

    }



} //class end
