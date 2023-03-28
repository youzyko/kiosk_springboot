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
public class NonCoffeeToppingDtoAll {
    private List<NonCoffeeToppingDto> nonCoffeeToppingDtos;
    public  NonCoffeeToppingDtoAll(List<Toppping> topppingList){
        this.convertDtoList(topppingList);
    }
    public void convertDtoList(List<Toppping> topppings){
        List<NonCoffeeToppingDto> dtos=new ArrayList<>();
        for (Toppping toppping: topppings){
            dtos.add(new NonCoffeeToppingDto(toppping));
        }
        this.nonCoffeeToppingDtos=dtos;
    }
}
