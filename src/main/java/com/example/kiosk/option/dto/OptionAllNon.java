package com.example.kiosk.option.dto;

import com.example.kiosk.option.entity.Option;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class OptionAllNon {
  private NonCoffeeDto noncoffeeOptions;  //커피

    public OptionAllNon(Option optionList){
        this.convertListCoffee(optionList);
    }

    public void convertListCoffee(Option options){
       NonCoffeeDto dtos=new NonCoffeeDto(options);
       /* for (Option option:options){
            dtos.add(new NonCoffeeDto(option));
        }*/
        this.noncoffeeOptions=dtos;
    }
}//class_end
