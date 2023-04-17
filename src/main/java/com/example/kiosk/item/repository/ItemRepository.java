package com.example.kiosk.item.repository;

import com.example.kiosk.item.entity.Item;
import com.example.kiosk.mainImage.entity.MainImg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemRepository {
    List<Item> menuTea(int itemId);
    boolean save(Item item); // 이미지 등록


}
