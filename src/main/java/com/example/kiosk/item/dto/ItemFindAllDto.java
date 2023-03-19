package com.example.kiosk.item.dto;

import com.example.kiosk.item.entity.Item;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor

public class ItemFindAllDto {

    private List<ItemDto> items; //userId 제외한 상품 목록

    public ItemFindAllDto(List<Item> itemList){

        this.convertDtoList(itemList);
    }
    public void convertDtoList(List<Item> itemList){
        List<ItemDto> dtos=new ArrayList<>();
        for (Item item:itemList){
            dtos.add(new ItemDto(item));
        }
        this.items=dtos;
    }
}
