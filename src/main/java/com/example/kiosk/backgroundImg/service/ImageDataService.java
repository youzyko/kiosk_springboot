package com.example.kiosk.backgroundImg.service;

import com.example.kiosk.backgroundImg.entity.ImageData;

import com.example.kiosk.backgroundImg.repository.ImageDataRepository;
import com.example.kiosk.util.ImageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Struct;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageDataService {
    private final ImageDataRepository imageDataRepository;

    public ImageData uploadServ(final ImageData imageData){
        ImageData backImg= (ImageData) imageDataRepository.uploadImgRepo(imageData);
        log.info("======backImg_serv"+backImg);
        return backImg;
    }

 /*   public String uploadImage(MultipartFile file) throws IOException {
        log.info("upload file: {}", file);
        ImageData imageData = storageRepository.save(
                ImageData.builder()
                        .name(file.getOriginalFilename())
                        .type(file.getContentType())
                        .imageData(ImageUtils.compressImage(file.getBytes()))
                        .build());
        if (imageData != null) {
            log.info("imageData: {}", imageData);
            return "file uploaded successfully : " + file.getOriginalFilename();
        }

        return null;
    }*/
}
