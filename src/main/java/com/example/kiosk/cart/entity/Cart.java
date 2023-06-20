package com.example.kiosk.cart.entity;

import com.example.kiosk.cart.dto.Toppingcart;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.util.Map;

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

    private  String sweetness; //당도

    private  int random; //랜덤수
    private List<Map<String, Object>>  selectedToppings;

    //MAP-JSON간 변환
    private String selectedToppingsJson ;

    public String getSelectedToppingsJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(selectedToppings);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setSelectedToppingsJson(String selectedToppingsJson) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            this.selectedToppings = mapper.readValue(selectedToppingsJson, new TypeReference<List<Map<String, Object>>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }




    public  Cart (Cart cart){

        this.here=cart.getHere();
        this.hot=cart.getHot();
        this.ice=cart.getIce();
        this.itemName= cart.getItemName();
        this.itemPrice=cart.getItemPrice();
        this.itemImg=cart.getItemImg();
        this.sweetness= cart.getSweetness();
        this.random=cart.getRandom();
        this.selectedToppings=cart.getSelectedToppings();
/*     this.toppingName=cart.getToppingName();
     this.toppingPrice= cart.getToppingPrice();*/
    }



}