package com.example.kiosk.cart.service;

import com.example.kiosk.cart.dto.CartList;
import com.example.kiosk.cart.entity.Cart;
import com.example.kiosk.cart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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


}//class_end
