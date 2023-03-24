package com.example.kiosk.option.dto;

import com.example.kiosk.option.entity.Option;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeDto {
    private  String menuName; //음료이름(PK)
    private int menuId; // 1-밀크티 2-커피...
    private  int countNum; //수량
    private  int hereTogo; // 포장/매장
    private int hotCold; // hot/cold
    private int coffeeTopping; // 샷추가
    private int shotPrice; // 샷추가 가격

    public  CoffeeDto(Option option){
        this.menuName=option.getMenuName();
        this.menuId=option.getMenuId();
        this.countNum=option.getCountNum();
        this.hereTogo=option.getHereTogo();
        this.hotCold=option.getHotCold();
        this.coffeeTopping=option.getCoffeeTopping();
        this.shotPrice=option.getShotPrice();
    }


}//class end
