package com.example.kiosk.item.api;

import com.example.kiosk.item.dto.ItemFindAllDto;
import com.example.kiosk.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/item")
@RequiredArgsConstructor
@CrossOrigin
public class ItemController {
    private final ItemService itemService;

    @GetMapping(value = {"/{itemId}"}) //itemId==1 itemId==2
    public ResponseEntity<?> MenuTeaAll(@PathVariable int itemId){
        log.info("=============milkTea_controller");
            return ResponseEntity.ok().body(itemService.menuTeaServ(itemId));
    } // getmapping_end



}//class end
