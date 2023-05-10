package com.example.kiosk.item.entity;

import com.example.kiosk.item.dto.ItemDto;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor

@Builder
public class Item {
    private  int itemId; //상품아이디
    private String itemName; //상품 이름(PK)
    private  int itemPrice; //상품 가격
   // private  String itemDetail; //상품 상세 내용
    private  int countNum; //수량
    private boolean status; //상품상태(판매중/품절)

    private String itemImg; //상품이미지
    //private  String userId; //상품 등록한 자(admin)
    private String ownImgId;

 public Item() { //랜덤아이디(중복방지)
        this.ownImgId = UUID.randomUUID().toString();
    }

    public Item(ItemDto itemDto) {
        this();
        this.itemId=itemDto.getItemId();
        this.itemName=itemDto.getItemName();
        this.itemPrice=itemDto.getItemPrice();
       // this.countNum=itemDto.getCountNum();
        this.status=itemDto.isStatus();
        this.itemImg=itemDto.getItemImg();
    }

/*  public Item(Item item) {
        this.itemId=item.getItemId();
        this.itemName=item.getItemName();
        this.itemPrice=item.getItemPrice();
        this.countNum=item.getCountNum();
        this.status=item.isStatus();
        this.itemImg=item.getItemImg();
       this.ownImgId=UUID.randomUUID().toString();
    }*/

}
