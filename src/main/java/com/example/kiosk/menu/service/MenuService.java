package com.example.kiosk.menu.service;

import com.example.kiosk.menu.dto.ItemFindAllDto;


import com.example.kiosk.menu.entity.MenuName;
import com.example.kiosk.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;



    public ItemFindAllDto menuTeaServ() {
        log.info("MENUNAME_FINDALL_SERIVCE");

        return new ItemFindAllDto(menuRepository.menuTea());
    }



  public boolean createServ(MenuName menuName) {
      log.info("MENUNAME_ADD_SERIVCE");
   return  menuRepository.save(menuName);

  }

  public  ItemFindAllDto deleteServ(int id){
      log.info("MENUNAME_DELETE_SERIVCE");
      boolean delete=menuRepository.delete(id);
      if (!delete) {
          log.warn("delete fail!! not found id [{}]", id);
          throw new RuntimeException("delete fail!");
      }
      return  menuTeaServ();
  }


}//class_end
