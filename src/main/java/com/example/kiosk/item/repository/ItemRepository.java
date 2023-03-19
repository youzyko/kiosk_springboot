package com.example.kiosk.item.repository;

import com.example.kiosk.item.entity.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemRepository {
    List<Item> menuTea(int itemId);

}
