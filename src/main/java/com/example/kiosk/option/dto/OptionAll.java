package com.example.kiosk.option.dto;


import com.example.kiosk.option.entity.Option;
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
public class OptionAll {
  private CoffeeDto coffeeOptions;  //커피

    public OptionAll(Option optionList){
        this.convertListCoffee(optionList);
    }

    public void convertListCoffee(Option options){
        CoffeeDto dtos=new CoffeeDto(options);
      /*  for (Option option:options){
            dtos.add(new CoffeeDto(option));
        }*/
        this.coffeeOptions=dtos;
    }

}//class_end
