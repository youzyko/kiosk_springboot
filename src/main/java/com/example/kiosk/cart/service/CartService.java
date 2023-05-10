package com.example.kiosk.cart.service;

import com.example.kiosk.cart.entity.Cart;
import com.example.kiosk.cart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    public  boolean add(Cart cart){
        log.info("CARTADD_SERVICE");
        return  cartRepository.add(cart);
    }
}
