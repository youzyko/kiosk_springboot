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
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

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

    @GetMapping(value = {"/itemId/{itemId}"}) //itemId==1 itemId==2 해당되는 아이템 조회
    public ResponseEntity<?> MenuTeaAll(@PathVariable Integer itemId) throws IOException {
        log.info("ITEM_ALLID_CONTROLLER");
      return ResponseEntity.ok().body(itemService.menuTeaServ(itemId));
    } // getmapping_end


    @GetMapping("/bringownImgId")//ownImgId만 String[]로 나열
    public ResponseEntity<?> listAllId(){
        log.info("ITEM_ALLID_CONTROLLER");
        return ResponseEntity.ok().body(itemService.findAllId());
    }
    @GetMapping("/allItemInform")
    public ResponseEntity<?> allItemInform(){
        log.info("ITEM_ALLINFORMATION_CONTROLLER");
        return  ResponseEntity.ok().body(itemService.findAllItem());
    }

   @GetMapping(value = {"/ownImgId/{ownImgId}"}) //해당되는 ownImgId 그림 빼오기
    public ResponseEntity<?> ImgAll(@PathVariable String ownImgId) throws IOException{

        String itemPath = itemService.getProfilePath(ownImgId);
        log.info("itemIMG=={}",itemPath);
        String fullPath = uploadRootPath + File.separator + itemPath;
        log.info("fullPath=={}",fullPath);

        // 해당 경로를 파일 객체로 포장
        File targetFile = new File(fullPath);
        log.info("targetFile=={}",targetFile);

        //해당 파일 존재x
        if(!targetFile.exists()) return  ResponseEntity.notFound().build();

        // 파일 데이터를 바이트배열로 포장 (blob 데이터)...대상 파일을 복사하여 Byte 배열로 반환해주는 클래스
        byte[] rawImageData = FileCopyUtils.copyToByteArray(targetFile);
        log.info("rawImageData=={}",rawImageData);
        // 응답 헤더 정보 추가
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(FileUploadUtil.getMediaType(itemPath));

        // 클라이언트에 순수 이미지파일 데이터 리턴
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(rawImageData);
    }

    @PostMapping("/register") //상세상품 등록
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

    } //postMapping_/register

    @DeleteMapping("/ownImgId/{ownImgId}")
    public ResponseEntity<?> delete(@PathVariable String ownImgId){
        log.info("ITEM_DELETE_CONTROLLER");
        try{
            boolean itemFindAllDto=itemService.delete(ownImgId);
            return ResponseEntity.ok().body(itemFindAllDto);
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }


}//class end
