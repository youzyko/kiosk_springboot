package com.example.kiosk.topping.api;



import com.example.kiosk.item.dto.ItemDto;
import com.example.kiosk.item.entity.Item;
import com.example.kiosk.topping.dto.NonCoffeeToppingDto;
import com.example.kiosk.topping.entity.Toppping;
import com.example.kiosk.topping.service.TopppingService;
import com.example.kiosk.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/api/topping")
@RequiredArgsConstructor
@CrossOrigin
public class ToppingController {
    private  final TopppingService topppingService;

    @Value("${upload.path}")
    private String uploadRootPath;


    @GetMapping //저장된 토핑 다 불러오기
    public ResponseEntity<?> toppingAll(){
        log.info("GET_TOPPING_CONTROLLER");
        return ResponseEntity.ok().body(topppingService.toppingAll());
    }

    @PostMapping("/register") //토핑 등록
    public ResponseEntity<?> register(@RequestPart(value="toppingImg",required = true) MultipartFile toppingImg,
                                      @RequestPart("toppingInfo") Toppping toppping
            /*  @PathVariable int menuName*/
            /*    @RequestPart("menuId") MenuName menuName*/
    ) throws IOException {
        try {
            log.info("TOPPING_ADD_CONTROLLER");
            Toppping toppping1=new Toppping(toppping); //랜덤 ownImgId 받아오기
          //  log.info("ITEM_ADD_CONTROLLER_item=======>{}",item1);

            // log.info(String.valueOf(menuName));
            // log.info(String.valueOf(menuname));   && item1.getItemId()== menuname.getMenuId()
            if(toppingImg!=null  ){
                log.info("itemImg : {}", toppingImg.getOriginalFilename());
                String originalFilename = toppingImg.getOriginalFilename();

                // 1-a-1. 파일명이 중복되지 않도록 변경
                String uploadFileName = UUID.randomUUID() + "_" + originalFilename;

                // 1-a-2. 업로드 폴더를 날짜별로 생성
                String newUploadPath = FileUploadUtil.makeUploadDirectory(uploadRootPath);

                File uploadFile = new File(newUploadPath + File.separator + uploadFileName);

                // 1-b. 파일을 해당 경로에 업로드
                toppingImg.transferTo(uploadFile);
                log.info("profileImg : {}", toppingImg.getOriginalFilename());
                // 2. 데이터베이스에 이미지 정보를 저장 - 누가 어떤사진을 올렸는가

                // 2-a. newUploadPath에서 rootPath를 제거
                //  ex) new: E:/profile_upload/2023/01/07
                //      root: E:/profile_upload
                //      new - root == /2023/01/07

                // str: hello java
                // str.substring(6) => 6번부터 끝까지 추출 == java
                String savePath
                        = newUploadPath.substring(uploadRootPath.length());
                toppping1.setToppingImg(savePath + File.separator + uploadFileName);
            } //if절
            boolean f=topppingService.upload(toppping1);
            return ResponseEntity.ok().body(f);

        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    } //postMapping_/register

    @GetMapping ()//ownImgid에 따라 이미지 가져오기






 /*   @GetMapping (value = {"/{menuId}"}) //논커피류
    public ResponseEntity<?> TopppingAllNon (@PathVariable int menuId){
        if(menuId==4){
            return ResponseEntity.ok().body(topppingService.coffeeToppingServ(menuId));
        }else{
            return ResponseEntity.ok().body(topppingService.noncoffeeToppingServ(menuId));
        }*/
   /*     if(menuId==0 || menuId==1||menuId==2||menuId==3){
            log.info("=============ToppingController");

        }
        return null;*/
    // getmapping_end

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
