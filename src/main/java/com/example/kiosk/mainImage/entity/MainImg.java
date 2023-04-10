package com.example.kiosk.mainImage.entity;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor

@Builder
public class MainImg {
    private String id;
    private String mainImg;



   public MainImg() {
        this.id = UUID.randomUUID().toString();
    }

    public MainImg(MainImg mainImg) {
        this.id=mainImg.getId();
        this.mainImg=mainImg.getMainImg();

    }



}//class_end
