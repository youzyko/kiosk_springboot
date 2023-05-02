package com.example.kiosk.mainImage.repository;

import com.example.kiosk.mainImage.entity.MainImg;
import org.apache.ibatis.annotations.Mapper;
import org.jboss.jandex.Main;

import java.util.List;

@Mapper
public interface MainImgRepository {
    boolean save(MainImg mainImg); // 이미지 등록

 String findBackImg(String id);
  /* String findBackImg();*/
    List<String> findAllId(); //아이디 목록
    boolean delete(String id); //삭제
List<MainImg> allInform();
}


