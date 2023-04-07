package com.example.kiosk.mainImage.api;

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

import java.io.*;
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

    @GetMapping  //이미지 나열
    public ResponseEntity<?> loadImg() throws  IOException {

        List<MainImg> backImgPath = mainImgService.getProfilePath();
        log.info("backImgPath=={}", backImgPath);
        ///backImgPath==[\2023\04\03\95c60820-4a1f-4111-96a9-7798ac863583_images (1).jpg,
        // \2023\04\06\a3e27c4b-050f-4509-8266-3adf76c8fd4d_images (1).jpg]

        //rawImageData를 한번에 받을 수 있는 공간이 필요함

        List<byte[]> container=new ArrayList<>();
        Iterator<MainImg> iterator = backImgPath.iterator();
        while (iterator.hasNext()) {
            String element = String.valueOf(iterator.next());
            log.info("element=={}", element);
            // element==\2023\04\03\95c60820-4a1f-4111-96a9-7798ac863583_images (1).jpg
            //element==\2023\04\07\dc0e5ae9-aabe-4f30-90dc-aab896f755f6_images (1).jpg

            String fullPath = uploadRootPath + File.separator + element;
            log.info("fullPath=={}", fullPath);
            //C:/profile_upload\\2023\04\03\95c60820-4a1f-4111-96a9-7798ac863583_images (1).jpg
            //C:/profile_upload\\2023\04\07\dc0e5ae9-aabe-4f30-90dc-aab896f755f6_images (1).jpg

            File targetFile = new File(fullPath);
            log.info("targetFile=={}", targetFile);
            //targetFile==C:\profile_upload\2023\04\03\95c60820-4a1f-4111-96a9-7798ac863583_images (1).jpg
            //targetFile==C:\profile_upload\2023\04\07\dc0e5ae9-aabe-4f30-90dc-aab896f755f6_images (1).jpg

            byte[] rawImageData= FileCopyUtils.copyToByteArray(targetFile);
            log.info("rawImageData=={}", rawImageData);
            //rawImageData==[-1, -40, -1, -32, 0, 16, 74, 70, 73, 70, 0, 1, 1, 0, 0, 1, 0, ~]
            //rawImageData==[-1, -40, -1, -32, 0, 16, 74, 70, 73, 70, 0, 1, 1, 0, 0, 1, 0, ~]

            //return ResponseEntity.ok().body(rawImageData); //rawImageData[0] 조차 못 받아옴

            container.add(rawImageData);


        } //while_end

        log.info("container=={}", container);
        // container==[[-1, -40,3 0~].[-1, -40,3 0~]]



      //  log.info("rawImageData=={}", rawImageData); //마지막 값만 출력

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(FileUploadUtil.getMediaType(backImgPath.toString()));

        return //null;
                ResponseEntity.ok().headers(headers).body(container.get(0));
    }


}//class_end
