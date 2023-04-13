package com.example.kiosk.menu.dto;


import com.example.kiosk.menu.entity.MenuName;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor


public class ItemFindAllDto {
    private List<MenuName> items; //userId 제외한 상품 목록

    public ItemFindAllDto(List<MenuName> itemList){

        this.convertDtoList(itemList);
    }
    public void convertDtoList(List<MenuName> itemList){
        List<MenuName> dtos=new ArrayList<>();
        for (MenuName item:itemList){
            dtos.add(new MenuName(item));
        }
        this.items=dtos;
    }
}
