package com.example.kiosk.topping.service;



import com.example.kiosk.item.entity.Item;
import com.example.kiosk.topping.dto.CoffeeToppingDtoAll;
import com.example.kiosk.topping.dto.NonCoffeeToppingDtoAll;
import com.example.kiosk.topping.entity.Toppping;
import com.example.kiosk.topping.repository.TopppingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TopppingService {
    private  final TopppingRepository topppingRepository;

    public List<Toppping> toppingAll(){ // 모든토핑
        log.info("GET_TOPPING_SERVICE");
        return  topppingRepository.toppingAll();
    }

    public boolean upload(Toppping toppping) { //이미지 등록
        log.info("ITEM_ADD_SERVICE");
        return topppingRepository.save(toppping);
    }


 /*   public CoffeeToppingDtoAll coffeeToppingServ(int menuId){
        log.info("===========coffeeToppingServ");
        return new CoffeeToppingDtoAll(topppingRepository.coffeeToppingOption(menuId));
    }

    public NonCoffeeToppingDtoAll noncoffeeToppingServ(int menuId){
        log.info("===========noncoffeeToppingServ");
        return new NonCoffeeToppingDtoAll((List<Toppping>)topppingRepository.nonCoffeeToppingOption(menuId));
    }*/



}//class_end
