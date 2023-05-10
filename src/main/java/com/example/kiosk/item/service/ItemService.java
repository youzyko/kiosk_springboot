package com.example.kiosk.item.service;

import com.example.kiosk.item.dto.ItemFindAllDto;

import com.example.kiosk.item.entity.Item;
import com.example.kiosk.item.repository.ItemRepository;
import com.example.kiosk.menu.entity.MenuName;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public List<Integer> onlyId(MenuName menuId){
        log.info("ITEM_onlyId_SERVICE");
        return itemRepository.onlyId(menuId);
    }
    public ItemFindAllDto menuTeaServ(int itemId) { //해당하는 상세상품만 뿌리기
        log.info("=============milkTea_Service");
        return new ItemFindAllDto(
 itemRepository.menuTea(itemId));
    }


    public boolean upload(Item item) { //이미지 등록
        log.info("ITEM_ADD_SERVICE");
        return itemRepository.save(item);
    }

    public List<String> findAllId() { //ownImgId만 가져오기
        log.info("ITEM_ALLID_SERVICE");
        return itemRepository.findAllId();
    }


    public String getProfilePath(String ownImgId){
        String itemImg=itemRepository.findImg(ownImgId);
        log.info("find profile path - {}", itemImg);
        return  itemImg;
    }


    public List<Item> findAllItem() {
        log.info("ITEM_ALLINFORM_SERVICE");
        return itemRepository.findAllItem();
    }

    public boolean delete(String ownImgId){
        log.info("ITEM_DELETE_SERVICE");
        boolean f=itemRepository.delete(ownImgId);
        if(!f){
            log.warn("DELETE_FAIL==>{}",ownImgId);
            throw  new RuntimeException("delete fail!");
   }
        return  f;
    }

   public Item detail(String itemName){
        log.info("ITEM_ITEMNAME_SERVICE");
        return  itemRepository.detail(itemName);
    }


}//class_end
