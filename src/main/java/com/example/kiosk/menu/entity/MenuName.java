package com.example.kiosk.menu.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor //클래스에 존재하는 모든 필드에 대한 생성자를 자동으로 생성해줍니다.
@NoArgsConstructor//파라미터가 없는 생성자 생성
/*@Builder*/
public class MenuName {
    private  int menuId; //상품아이디
    private String menuName; //상품 이름(PK)

    public MenuName(MenuName menuName){
        this.menuId=menuName.getMenuId();
        this.menuName=menuName.getMenuName();
    }





}
