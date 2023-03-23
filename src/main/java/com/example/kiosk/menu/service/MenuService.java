package com.example.kiosk.menu.service;

import com.example.kiosk.menu.dto.ItemFindAllDto;


import com.example.kiosk.menu.entity.MenuName;
import com.example.kiosk.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    public ItemFindAllDto menuTeaServ() {
        log.info("=============only menuname_Service");
        return new ItemFindAllDto((List<MenuName>) menuRepository.menuTea());
    }



}//class_end
