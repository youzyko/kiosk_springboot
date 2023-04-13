package com.example.kiosk.item.api;

import com.example.kiosk.item.dto.ItemFindAllDto;

import com.example.kiosk.item.service.ItemService;
import com.example.kiosk.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/item")
@RequiredArgsConstructor
@CrossOrigin

//item... 상세메뉴 ex) 블랙밀크티,타로밀크티...
//menu... 큰카테고리 ex) 밀크티,스무디...
public class ItemController {

    private final ItemService itemService;

    @GetMapping(value = {"/{itemId}"}) //itemId==1 itemId==2
    public ResponseEntity<?> MenuTeaAll(@PathVariable int itemId){
        log.info("=============milkTea_controller");
            return ResponseEntity.ok().body(itemService.menuTeaServ(itemId));
    } // getmapping_end




}//class end
