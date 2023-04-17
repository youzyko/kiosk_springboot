package com.example.kiosk.item.service;

import com.example.kiosk.item.dto.ItemFindAllDto;

import com.example.kiosk.item.entity.Item;
import com.example.kiosk.item.repository.ItemRepository;
import com.example.kiosk.mainImage.entity.MainImg;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemFindAllDto menuTeaServ(int itemId) {
        log.info("=============milkTea_Service");
        return new ItemFindAllDto(/*(List<Item>)*/ itemRepository.menuTea(itemId));
    }

    public boolean upload(Item item) { //이미지 등록
        log.info("ITEM_ADD_SERVICE");
        return itemRepository.save(item);
    }



}//class_end
