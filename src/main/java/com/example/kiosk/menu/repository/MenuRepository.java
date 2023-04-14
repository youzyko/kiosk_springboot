package com.example.kiosk.menu.repository;


import com.example.kiosk.menu.entity.MenuName;
import org.apache.ibatis.annotations.Mapper;

import java.awt.*;
import java.util.List;

@Mapper
public interface MenuRepository {
    List<MenuName> menuTea();

  boolean save(MenuName menuName);

  boolean delete(int id);
}
