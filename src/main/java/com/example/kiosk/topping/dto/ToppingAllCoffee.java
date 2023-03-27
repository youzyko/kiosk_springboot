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
public class ToppingAllCoffee {
    private List<TopppingCoffeDto> topppings; //userId 제외한 상품 목록

    public void TopppingDto(List<Toppping> itemList){
        this.convertDtoList(itemList);
    }
    public void convertDtoList(List<Toppping> itemList){
        List<TopppingCoffeDto> dtos=new ArrayList<>();
        for (Toppping item:itemList){
            dtos.add(new TopppingCoffeDto(item));
        }
        this.topppings=dtos;
    }


   /*private CoffeeDto coffeeOptions;  //커피

    public OptionAll(Option optionList){
        this.convertListCoffee(optionList);
    }

    public void convertListCoffee(Option options){
        CoffeeDto dtos=new CoffeeDto(options);
       for (Option option:options){
            dtos.add(new CoffeeDto(option));
        }
        this.coffeeOptions=dtos;
    }*/

}//class_end
