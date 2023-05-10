package com.example.kiosk.cart.api;

import com.example.kiosk.cart.entity.Cart;
import com.example.kiosk.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/cart")
@RequiredArgsConstructor
@CrossOrigin
public class CartController {
    private  final CartService cartService;
    @PostMapping("/incart")
    public ResponseEntity<?> addcart(@RequestPart("optionInfo") Cart cart){
        log.info("ADDCART_CONTROLLER");
        Cart cart1=new Cart(cart);
        boolean f=cartService.add(cart1);
        return  ResponseEntity.ok().body(f);
    }

}
