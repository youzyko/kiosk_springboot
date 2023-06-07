package com.example.kiosk.cart.service;

import com.example.kiosk.cart.dto.CartList;
import com.example.kiosk.cart.entity.Cart;
import com.example.kiosk.cart.repository.CartRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

 public  boolean add(Cart cart){ //선택 항목 받아오기
        log.info("CARTADD_SERVICE");
        return  cartRepository.add(cart);
    }




    public List<Cart> showAll(){ //전체항목
        log.info("SHOWALL_SERVICE");
        return cartRepository.showAll();
    }
    public String getProfilePath(String ownImgId){
        log.info("GETIMG_SERVICE");
        String itemImg=cartRepository.findImg(ownImgId);
        log.info("find profile path - {}", itemImg);
        return  itemImg;
    }

    public boolean delete(String itemName){
        log.info("CART_DELETE_SERVICE");
        return cartRepository.delete(itemName);
    }

 /*   public boolean existsByName(String itemName){
        log.info("CART_EXISTBYNAME_SERVICE");
        return cartRepository.existsByItemName(itemName);
    }*/
    public boolean deleteall(Cart cart){
        log.info("DELETE_ALL_SERVICE");
        return  cartRepository.deleteall(cart);
    }


}//class_end
