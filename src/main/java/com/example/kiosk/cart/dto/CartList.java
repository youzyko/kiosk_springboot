package com.example.kiosk.cart.dto;

import com.example.kiosk.cart.entity.Cart;
import com.example.kiosk.item.dto.ItemDto;
import com.example.kiosk.item.entity.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class CartList {
    private List<Cart> cartList;

    public CartList(List<Cart> cartList){
        this.convertDtoList(cartList);
    }

    public void convertDtoList(List<Cart> cartList){
        List<Cart> dtos=new ArrayList<>();
        for (Cart cart:cartList){
            dtos.add(new Cart(cart));
        }
        this.cartList=dtos;
    }
}
