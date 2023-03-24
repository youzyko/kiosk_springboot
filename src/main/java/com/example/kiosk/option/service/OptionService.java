package com.example.kiosk.option.service;

import com.example.kiosk.option.dto.NonCoffeeDto;
import com.example.kiosk.option.dto.OptionAll;
import com.example.kiosk.option.dto.OptionAllNon;
import com.example.kiosk.option.repository.OptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OptionService {
    private final OptionRepository optionRepository;

    public OptionAll optionCoffeeServ(int menuId){
        log.info("=============optionServ_Service_coffee");
      if(menuId==4){
          return new OptionAll(optionRepository.coffeeOption(menuId)) ;
      }
        return null;
    }

    public OptionAllNon optionNonCoffeeServ(int menuId){
        log.info("=============optionNonCoffeeServ_Service");
        if(menuId>=0 || menuId<4){
            return new OptionAllNon(optionRepository.nonCoffeeOption(menuId)) ;
        }
        return null;
    }






}//class_end
