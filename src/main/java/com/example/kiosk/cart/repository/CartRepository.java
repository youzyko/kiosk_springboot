package com.example.kiosk.cart.repository;

import com.example.kiosk.cart.entity.Cart;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartRepository {
    boolean add(Cart cart);
}
