package com.example.kiosk.topping.repository;


import com.example.kiosk.item.entity.Item;
import com.example.kiosk.topping.dto.NonCoffeeToppingDto;
import com.example.kiosk.topping.entity.Toppping;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TopppingRepository {

/* List<Toppping> coffeeToppingOption(int menuId);

    List<Toppping> nonCoffeeToppingOption(int menuId);*/

    List<Toppping> toppingAll();
    boolean save(Toppping toppping); //새로운 토핑등록
}//class_end
