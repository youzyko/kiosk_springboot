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
public class CoffeeToppingDtoAll {
    private List<CoffeeToppingDto> coffeeToppingDtos;
    public CoffeeToppingDtoAll(List<Toppping> topppingList){
        this.convertDtoList(topppingList);
    }
    public void convertDtoList(List<Toppping> topppings){
        List<CoffeeToppingDto> dtos=new ArrayList<>();
        for (Toppping toppping: topppings){
            dtos.add(new CoffeeToppingDto(toppping));
        }
        this.coffeeToppingDtos=dtos;
    }

}
