package com.example.kiosk.menu.entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuName {
    private  int MenuId; //상품아이디
    private String MenuName; //상품 이름(PK)

    public MenuName(MenuName menuName){
        this.MenuId=menuName.getMenuId();
        this.MenuName=menuName.getMenuName();
    }
}
