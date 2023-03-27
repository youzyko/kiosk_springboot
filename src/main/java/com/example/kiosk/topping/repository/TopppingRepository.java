package com.example.kiosk.topping.repository;


import com.example.kiosk.item.entity.Item;
import com.example.kiosk.topping.dto.ToppingAllCoffee;
import com.example.kiosk.topping.dto.TopppingCoffeDto;
import com.example.kiosk.topping.dto.TopppingNonCoffeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TopppingRepository {
    List<TopppingCoffeDto> coffeeToppingOption(int itemId);
    List<TopppingNonCoffeDto> noncoffeeToppingOption(int itemId);

}//class_end
