package com.example.kiosk.item.api;

import com.example.kiosk.item.dto.ItemDto;
import com.example.kiosk.item.dto.ItemFindAllDto;

import com.example.kiosk.item.entity.Item;
import com.example.kiosk.item.service.ItemService;
import com.example.kiosk.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/api/item")
@RequiredArgsConstructor
@CrossOrigin


//item... 상세메뉴 ex) 블랙밀크티,타로밀크티...
//menu... 큰카테고리 ex) 밀크티,스무디...
public class ItemController {
    @Value("${upload.path}")
    private String uploadRootPath;
    private final ItemService itemService;

    @GetMapping(value = {"/{itemId}"}) //itemId==1 itemId==2 해당되는 아이템 조회
    public ResponseEntity<?> MenuTeaAll(@PathVariable int itemId){
        log.info("=============milkTea_controller");
            return ResponseEntity.ok().body(itemService.menuTeaServ(itemId));
    } // getmapping_end

    @GetMapping(value = {"/{ownImgId}"})//전체조회
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestPart(value="itemImg",required = false)MultipartFile itemImg,
                                      @RequestPart("itemInfo")ItemDto itemDto) throws  IOException{
        try {
            log.info("ITEM_ADD_CONTROLLER");
            Item item1=new Item(itemDto); //랜덤 ownImgId 받아오기
            log.info("ITEM_ADD_CONTROLLER_item=======>{}",item1);
            if(itemImg!=null){
                log.info("itemImg : {}", itemImg.getOriginalFilename());
                String originalFilename = itemImg.getOriginalFilename();

                // 1-a-1. 파일명이 중복되지 않도록 변경
                String uploadFileName = UUID.randomUUID() + "_" + originalFilename;

                // 1-a-2. 업로드 폴더를 날짜별로 생성
                String newUploadPath = FileUploadUtil.makeUploadDirectory(uploadRootPath);

                File uploadFile = new File(newUploadPath + File.separator + uploadFileName);

                // 1-b. 파일을 해당 경로에 업로드
                itemImg.transferTo(uploadFile);
                log.info("profileImg : {}", itemImg.getOriginalFilename());
                // 2. 데이터베이스에 이미지 정보를 저장 - 누가 어떤사진을 올렸는가

                // 2-a. newUploadPath에서 rootPath를 제거
                //  ex) new: E:/profile_upload/2023/01/07
                //      root: E:/profile_upload
                //      new - root == /2023/01/07

                // str: hello java
                // str.substring(6) => 6번부터 끝까지 추출 == java
                String savePath
                        = newUploadPath.substring(uploadRootPath.length());
                item1.setItemImg(savePath + File.separator + uploadFileName);
            } //if절
            boolean f=itemService.upload(item1);
            return ResponseEntity.ok().body(f);

        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    } //postMapping





}//class end
