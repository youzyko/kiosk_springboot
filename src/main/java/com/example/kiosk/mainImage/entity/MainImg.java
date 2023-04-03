package com.example.kiosk.mainImage.entity;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor

@Builder
public class MainImg {
    private String mainImg;
    private String id;
    public MainImg() {
        this.id = UUID.randomUUID().toString();
    }


   public MainImg(MainImg entity) {
        this();
        this.mainImg= entity.getMainImg();
        this.id= entity.getId();
    }

    public MainImg(String id) {
        this.id= id;
    }
}//class_end
