package com.example.kiosk.option.api;

import com.example.kiosk.option.service.OptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/option")
@RequiredArgsConstructor
@CrossOrigin
public class OptionController {
    private  final OptionService optionService;
    @GetMapping(value = "/{menuId}") //메뉴를 클릭하면 옵션이 쭉 뜸
    public ResponseEntity<?> OptionAll(@PathVariable (value="menuId",required=false) int menuId){
        log.info("=============OptionAll_controller{}=============",menuId);
        if(menuId==4){
            return ResponseEntity.ok().body(optionService.optionCoffeeServ(menuId));
        }
        else{
            return ResponseEntity.ok().body(optionService.optionNonCoffeeServ(menuId));
        }
    }



} //class_end
