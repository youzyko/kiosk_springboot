package com.example.kiosk.option.repository;

import com.example.kiosk.option.entity.Option;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OptionRepository {
    List<Option> coffeeOption(int menuId);

    List<Option> nonCoffeeOption(int menuId);
}//class_end
