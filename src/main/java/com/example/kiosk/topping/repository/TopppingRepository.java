package com.example.kiosk.topping.repository;


import com.example.kiosk.item.entity.Item;

import com.example.kiosk.topping.entity.Toppping;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TopppingRepository {
    List<Toppping> toppingAll();
    boolean save(Toppping toppping); //새로운 토핑등록

    String findImg(String ownImgId); //ownImgId에 해당하는 이미지

    List<String> findAllId(); //아이디 목록

    boolean delete(String ownImgId); //삭제

}//class_end
