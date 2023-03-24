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
public class OptionAllNon {
  private List<NonCoffeeDto> noncoffeeOptions;  //커피

    public OptionAllNon(List<Option> optionList){
        this.convertListCoffee(optionList);
    }

    public void convertListCoffee(List<Option> options){
        List<NonCoffeeDto> dtos=new ArrayList<>();
        for (Option option:options){
            dtos.add(new NonCoffeeDto(option));
        }
        this.noncoffeeOptions=dtos;
    }
}//class_end
