package com.example.kiosk.topping.api;



import com.example.kiosk.item.dto.ItemDto;
import com.example.kiosk.item.entity.Item;

import com.example.kiosk.menu.entity.MenuName;
import com.example.kiosk.topping.entity.Toppping;
import com.example.kiosk.topping.service.TopppingService;
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
import java.util.List;
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


    @GetMapping //전체정보_토핑
    public ResponseEntity<?> toppingAll(){
        log.info("GET_TOPPING_CONTROLLER");
        return ResponseEntity.ok().body(topppingService.toppingAll());
    }

    @PostMapping("/register") //토핑 등록+이미지까지
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
    @GetMapping("/bringownImgId")//ownImgId만 String[]로 나열...안씀
    public ResponseEntity<?> listAllId(){
        log.info("TOPPING_ALLID_CONTROLLER");
        return ResponseEntity.ok().body(topppingService.findAllId());
    }

    @GetMapping(value = {"/{ownImgId}"}) //해당되는 ownImgId 그림 빼오기
    public ResponseEntity<?> ImgAll(@PathVariable String ownImgId) throws IOException{

        String itemPath = topppingService.getProfilePath(ownImgId);
        log.info("TOPPING_IMG_CONTROLLER{}",itemPath);
        String fullPath = uploadRootPath + File.separator + itemPath;
        log.info("fullPath=={}",fullPath);

        // 해당 경로를 파일 객체로 포장
        File targetFile = new File(fullPath);
        log.info("targetFile=={}",targetFile);

        //해당 파일 존재x
        if(!targetFile.exists()) return  ResponseEntity.notFound().build();

        // 파일 데이터를 바이트배열로 포장 (blob 데이터)...대상 파일을 복사하여 Byte 배열로 반환해주는 클래스
        byte[] rawImageData = FileCopyUtils.copyToByteArray(targetFile);
       // log.info("rawImageData=={}",rawImageData);
        // 응답 헤더 정보 추가
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(FileUploadUtil.getMediaType(itemPath));

        // 클라이언트에 순수 이미지파일 데이터 리턴
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(rawImageData);
    } //ownimgid

    //삭제
    @DeleteMapping("/{ownImgId}")
    public ResponseEntity<?> delete(@PathVariable String ownImgId){
        log.info("TOPPING_DELETE_CONTROLLER");
        try{
            boolean f= topppingService.delete(ownImgId);
            return  ResponseEntity.ok().body(f);
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }







} //class_end
