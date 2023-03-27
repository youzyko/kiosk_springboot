package com.example.kiosk.topping.api;


import com.example.kiosk.option.service.OptionService;
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
    @GetMapping(value = {"/{menuId}"}) //itemId==1 itemId==2
    public ResponseEntity<?> TopppingAll (@PathVariable int menuId){
        log.info("=============ToppingController");
        if(menuId==4){
            log.info("======커피토핑만 출력합니다");
            return ResponseEntity.ok().body(topppingService.coffeeToppingServ(menuId));
        }else{
            return ResponseEntity.ok().body(topppingService.noncoffeeToppingServ(menuId));
        }

    } // getmapping_end






} //class_end
