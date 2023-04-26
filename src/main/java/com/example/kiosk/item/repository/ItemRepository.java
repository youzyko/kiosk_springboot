package com.example.kiosk.item.repository;

import com.example.kiosk.item.dto.ItemFindAllDto;
import com.example.kiosk.item.entity.Item;
import com.example.kiosk.mainImage.entity.MainImg;
import com.example.kiosk.menu.entity.MenuName;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemRepository {
    List<Integer> onlyId(MenuName menuId);
   List<Item> menuTea(int itemId);
    boolean save(Item item); //  등록
    List<String> findAllId(); //아이디 목록
 List<Item> findAllItem(); //모든 상품목록
    String findImg(String ownImgId); //ownImgId에 해당하는 이미지
    boolean delete(String ownImgId); //삭제
}
