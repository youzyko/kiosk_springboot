package com.example.kiosk.topping.service;


import com.example.kiosk.option.dto.OptionAll;
import com.example.kiosk.option.dto.OptionAllNon;

import com.example.kiosk.topping.dto.TopppingCoffeDto;
import com.example.kiosk.topping.dto.TopppingNonCoffeDto;
import com.example.kiosk.topping.entity.Toppping;
import com.example.kiosk.topping.repository.TopppingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TopppingService {
    private  final TopppingRepository topppingRepository;
    public TopppingCoffeDto coffeeToppingServ(int menuId){
        log.info("=============coffeeToppingServ");
        if(menuId==4){
            return new TopppingCoffeDto((Toppping) topppingRepository.coffeeToppingOption(menuId)) ;
        }
        return null;
    }

    public TopppingNonCoffeDto noncoffeeToppingServ(int menuId){
        log.info("=============optionNonCoffeeServ_Service");
        if(menuId>=0 || menuId<4){
            return new TopppingNonCoffeDto((Toppping) topppingRepository.noncoffeeToppingOption(menuId)) ;
        }
        return null;
    }




}//class_end
