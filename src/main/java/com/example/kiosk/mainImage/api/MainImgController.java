package com.example.kiosk.mainImage.api;

import com.example.kiosk.mainImage.dto.ImgAll;
import com.example.kiosk.mainImage.entity.MainImg;
import com.example.kiosk.mainImage.service.MainImgService;
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
import java.lang.reflect.Array;
import java.util.*;

@RestController
@Slf4j
@RequestMapping("/api/image")
@RequiredArgsConstructor
@CrossOrigin
public class MainImgController {
    private  final MainImgService mainImgService;
    @Value("${upload.path}")
    private String uploadRootPath;

    @PostMapping("/upload")
    public ResponseEntity<?> upload( //베경이미지 등록
            @RequestPart(value="mainImg", required = false) MultipartFile mainImg
    ) throws IOException {
        MainImg mainImg1=new MainImg();
        log.info("mainIMG1================================{}",mainImg1);
        if (mainImg != null) {
            log.info("profileImg : {}", mainImg.getOriginalFilename());

            // 1. 서버에 이미지파일을 저장 - 이미지를 서버에 업로드

            // 1-a. 파일 저장 위치를 지정하여 파일 객체에 포장
            String originalFilename = mainImg.getOriginalFilename();

            // 1-a-1. 파일명이 중복되지 않도록 변경
            String uploadFileName = UUID.randomUUID() + "_" + originalFilename;

            // 1-a-2. 업로드 폴더를 날짜별로 생성
            String newUploadPath = FileUploadUtil.makeUploadDirectory(uploadRootPath);

            File uploadFile = new File(newUploadPath + File.separator + uploadFileName);

            // 1-b. 파일을 해당 경로에 업로드
            mainImg.transferTo(uploadFile);
            log.info("profileImg : {}", mainImg.getOriginalFilename());
            // 2. 데이터베이스에 이미지 정보를 저장 - 누가 어떤사진을 올렸는가

            // 2-a. newUploadPath에서 rootPath를 제거
            //  ex) new: E:/profile_upload/2023/01/07
            //      root: E:/profile_upload
            //      new - root == /2023/01/07

            // str: hello java
            // str.substring(6) => 6번부터 끝까지 추출 == java
            String savePath
                    = newUploadPath.substring(uploadRootPath.length());
            mainImg1.setMainImg(savePath + File.separator + uploadFileName);
        }//if 절
        boolean f = mainImgService.upload(mainImg1);
        return ResponseEntity.ok().body(f);
    }

    @GetMapping
    public ResponseEntity<?> loadImg() throws  IOException{
        List<MainImg> backImgPath = mainImgService.getProfilePath();
        log.info("backImgPath=={}",backImgPath);
        //backImgPath==[\2023\04\03\95c60820-4a1f-4111-96a9-7798ac863583_images (1).jpg, \2023\04\06\a3e27c4b-050f-4509-8266-3adf76c8fd4d_images (1).jpg]

        Iterator<MainImg> iterator=backImgPath.iterator();

        List<String> raw=new ArrayList<>();
        byte[] rawImageData=null;
        while (iterator.hasNext()){
            int i=0;
            String element = String.valueOf(iterator.next());
            log.info("element===={}",element);

            String fullPath = uploadRootPath + File.separator + element;
            //raw.add(fullPath);
            log.info("fullPath===={}",fullPath);

            File targetFile=new File(fullPath);
            log.info("targetFile=={}",targetFile);
            rawImageData = FileCopyUtils.copyToByteArray(targetFile);
           log.info(Arrays.toString(rawImageData));
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(FileUploadUtil.getMediaType(backImgPath.toString()));
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(rawImageData);

       // log.info("targetFile=={}",targetFile);
      /*  if(!targetFile.exists()) return  ResponseEntity.notFound().build();
        byte[] rawImageData = FileCopyUtils.copyToByteArray(targetFile);

        return ResponseEntity
                .ok()

                .body(rawImageData);*/
        // ex) E:/upload/2023/~~
     // String fullPath = uploadRootPath + File.separator + backImgPath;
      //log.info("fullPath=={}",fullPath);
        //C:/profile_upload\\2023\04\03\95c60820-4a1f-4111-96a9-7798ac863583_images (1).jpg
        //fullPath==C:/profile_upload\[\2023\04\03\95c60820-4a1f-4111-96a9-7798ac863583_images (1).jpg, \2023\04\06\a3e27c4b-050f-4509-8266-3adf76c8fd4d_images (1).jpg]
        //fullPath==[C:/profile_upload[\2023\04\03\95c60820-4a1f-4111-96a9-7798ac863583_images (1).jpg, \2023\04\06\a3e27c4b-050f-4509-8266-3adf76c8fd4d_images (1).jpg]]


        // 해당 경로를 파일 객체로 포장
       // File targetFile = new File(fullPath);
        //log.info("targetFile=={}",targetFile);
        //C:\profile_upload\2023\04\03\95c60820-4a1f-4111-96a9-7798ac863583_images (1).jpg
        //targetFile==C:\profile_upload\[\2023\04\03\95c60820-4a1f-4111-96a9-7798ac863583_images (1).jpg, \2023\04\06\a3e27c4b-050f-4509-8266-3adf76c8fd4d_images (1).jpg]


        //해당 파일 존재x
      //  if(!targetFile.exists()) return  ResponseEntity.notFound().build();

        // 파일 데이터를 바이트배열로 포장 (blob 데이터)...대상 파일을 복사하여 Byte 배열로 반환해주는 클래스
      //  byte[] rawImageData = FileCopyUtils.copyToByteArray(targetFile);

        // 응답 헤더 정보 추가
       // HttpHeaders headers = new HttpHeaders();
       // headers.setContentType(FileUploadUtil.getMediaType(backImgPath.toString()));

        // 클라이언트에 순수 이미지파일 데이터 리턴
       // return ResponseEntity
          //      .ok()
         //       .headers(headers)
           //     .body(rawImageData);

      /*  ImgAll profilePath = mainImgService.getProfilePath();
        log.info("{}",profilePath);
        return  ResponseEntity.ok().body(profilePath);*/

    }




}//class_end
