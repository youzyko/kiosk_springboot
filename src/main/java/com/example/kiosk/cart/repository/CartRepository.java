package com.example.kiosk.cart.repository;

import com.example.kiosk.cart.dto.CartList;
import com.example.kiosk.cart.entity.Cart;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartRepository {
    boolean add(Cart cart);
    List<Cart> showAll();
    String findImg(String ownImgId);
}
