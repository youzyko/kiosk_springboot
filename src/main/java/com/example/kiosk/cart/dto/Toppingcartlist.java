package com.example.kiosk.cart.dto;

import com.example.kiosk.item.dto.ItemDto;
import com.example.kiosk.item.entity.Item;
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
public class Toppingcartlist {
    private List<Toppingcart> toppingcartList;

    public Toppingcartlist(List<Toppingcart> toppingcartList1){
        this.convertDtoList(toppingcartList1);
    }
    public void convertDtoList(List<Toppingcart> itemList){
        List<Toppingcart> dtos=new ArrayList<>();
        for (Toppingcart item:itemList){
            dtos.add(new Toppingcart(item));
        }
        this.toppingcartList=dtos;
    }
}
