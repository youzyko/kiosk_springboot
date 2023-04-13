package com.example.kiosk.menu.api;



import com.example.kiosk.menu.entity.MenuName;
import com.example.kiosk.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@Slf4j
@RequestMapping("/api/name")
@RequiredArgsConstructor
@CrossOrigin

public class MenuController {

    private final MenuService menuService;

    @GetMapping
    public ResponseEntity<?> MenuTeaAll(){
        log.info("=============only menuName_controller");
        return ResponseEntity.ok().body(menuService.menuTeaServ());
    } // getmapping_end


 @PostMapping("/addmenu")
    public ResponseEntity<?> create(@RequestBody MenuName menuName ) {
        log.info("MENUNAME_ADD_CONTROLLER");
        log.info("menuName================================{}", menuName);
     MenuName menuName1=new MenuName(menuName);
        log.info("menuName1================================{}", menuName1);
        boolean b=menuService.createServ(menuName1);
        return   ResponseEntity.ok().body(b);

    }











}//class end
