package com.example.kiosk.topping.api;


import com.example.kiosk.option.service.OptionService;
import com.example.kiosk.topping.dto.NonCoffeeToppingDto;
import com.example.kiosk.topping.entity.Toppping;
import com.example.kiosk.topping.service.TopppingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/topping")
@RequiredArgsConstructor
@CrossOrigin
public class ToppingController {
    private  final TopppingService topppingService;
    @GetMapping (value = {"/{menuId}"}) //논커피류
    public ResponseEntity<?> TopppingAllNon (@PathVariable int menuId){
        if(menuId==4){
            return ResponseEntity.ok().body(topppingService.coffeeToppingServ(menuId));
        }else{
            return ResponseEntity.ok().body(topppingService.noncoffeeToppingServ(menuId));
        }
   /*     if(menuId==0 || menuId==1||menuId==2||menuId==3){
            log.info("=============ToppingController");

        }
        return null;*/
    } // getmapping_end

   /* @GetMapping(value = {"/{menuId}"})//커피류
    public ResponseEntity<?> TopppingAllCoffee (@PathVariable int menuId){
        log.info("======커피토핑만 출력합니다");
        if(menuId==4){
            return ResponseEntity.ok().body(topppingService.coffeeToppingServ(menuId));
        }
      return null;
    }*/

/*if(menuId==4){
            log.info("======커피토핑만 출력합니다");
            return ResponseEntity.ok().body(topppingService.coffeeToppingServ(menuId));
        }else {*/




} //class_end
