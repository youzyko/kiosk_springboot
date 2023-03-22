package com.example.kiosk.option.dto;

import com.example.kiosk.option.entity.Option;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NonCoffeeDto {
    private  String menuName; //음료이름(PK)
    private int menuId; // 1-밀크티 2-커피...
    private  int countNum; //수량
    private  int hereTogo; // 포장/매장
    private int hotCold; // hot/cold
    private int iceAmount; //얼음양 많이/중간/적게
    private int sweetness; //당도 달게/중간/덜달게
    private String topping; //토핑
    private int toppingPrice; //토핑가격

/*    public  NonCoffeeDto(Option option){
        this.menuName=option.getMenuName();
        this.menuId=option.getMenuId();
        this.countNum=option.getCountNum();
        this.hereTogo=option.getHereTogo();
        this.hotCold=option.getHotCold();
        this.iceAmount=option.getIceAmount();
        this.sweetness=option.getSweetness();
        this.topping=option.getTopping();
        this.toppingPrice=option.getToppingPrice();
    }*/


}
