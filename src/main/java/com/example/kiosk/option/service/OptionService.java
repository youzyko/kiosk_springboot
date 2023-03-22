package com.example.kiosk.option.service;

import com.example.kiosk.option.dto.CoffeeDto;
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

    public CoffeeDto optionCoffeeServ(int menuId){
        log.info("=============optionServ_Service");
      if(menuId==5){
          return new CoffeeDto();
      }
        return (CoffeeDto) optionRepository.coffeeOption(menuId);
    }

    public NonCoffeeDto optionNonCoffeeServ(int menuId){
        log.info("=============optionNonCoffeeServ_Service");
        if(menuId>=1 || menuId<5){
            return new NonCoffeeDto();
        }
        return (NonCoffeeDto) optionRepository.nonCoffeeOption(menuId);
    }






}//class_end
