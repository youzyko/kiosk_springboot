package com.example.kiosk.topping.dto;

import com.example.kiosk.topping.entity.Toppping;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@ToString
@NoArgsConstructor
public class TopppingAllNonCoffee {
    private List<TopppingNonCoffeDto> topppings; //userId 제외한 상품 목록

    public void TopppingDto(List<Toppping> itemList){
        this.convertDtoList(itemList);
    }
    public void convertDtoList(List<Toppping> itemList){
        List<TopppingNonCoffeDto> dtos=new ArrayList<>();
        for (Toppping item:itemList){
            dtos.add(new TopppingNonCoffeDto(item));
        }
        this.topppings=dtos;
    }

}
