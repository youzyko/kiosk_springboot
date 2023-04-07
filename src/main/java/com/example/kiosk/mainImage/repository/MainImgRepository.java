package com.example.kiosk.mainImage.repository;

import com.example.kiosk.mainImage.entity.MainImg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainImgRepository {
    boolean save(MainImg mainImg); // 이미지 등록

 List<String> findBackImg();
  /* String findBackImg();*/
}
