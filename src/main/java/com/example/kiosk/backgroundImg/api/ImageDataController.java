package com.example.kiosk.backgroundImg.api;

import com.example.kiosk.backgroundImg.dto.ImageDataDto;
import com.example.kiosk.backgroundImg.entity.ImageData;

import com.example.kiosk.backgroundImg.service.ImageDataService;
import com.example.kiosk.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/api/image")
@RequiredArgsConstructor
@CrossOrigin
public class ImageDataController{
    private final ImageDataService imageDataService;

    @Value("${upload.path}")
    private String uploadRootPath;

    @PostMapping("/upload")
    public ResponseEntity<?> upload( @RequestPart("userInfo") ImageDataDto reqDto,
           @RequestPart(value="profileImg", required = false) MultipartFile profileImg) throws IOException {
        try {
            ImageData imageData1 = new ImageData(reqDto);
            log.info("/api/image/upload POST!! - imageInfo : {}", reqDto);
            if (profileImg != null) {
                log.info("profileImg : {}", profileImg.getOriginalFilename());
                //log.info("profileImg : {}", profileImg.());
                String originalFilename = profileImg.getOriginalFilename();

                // 1-a-1. 파일명이 중복되지 않도록 변경
                String uploadFileName = UUID.randomUUID() + "_" + originalFilename;

                // 1-a-2. 업로드 폴더를 날짜별로 생성
                String newUploadPath = FileUploadUtil.makeUploadDirectory(uploadRootPath);

                File uploadFile = new File(newUploadPath + File.separator + uploadFileName);
                profileImg.transferTo(uploadFile);

                String savePath
                        = newUploadPath.substring(uploadRootPath.length());

                imageData1.setName(savePath + File.separator + uploadFileName);
            } //if_end
            ImageData imageData2 = imageDataService.uploadServ(imageData1);
            return ResponseEntity.ok().body(imageData2);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }



/*
    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException, IOException {
        String uploadImage = storageService.(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
 }
*/



 /*   @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file,
                                         @RequestParam("id")int id) {
        ImageData imageData=new ImageData();

    }*/

}//class_end
