package com.example.kiosk.menu.api;


import com.example.kiosk.menu.entity.MenuName;
import com.example.kiosk.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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



}//class end
