package com.example.kiosk.mainImage.repository;

import com.example.kiosk.mainImage.entity.MainImg;
import org.apache.ibatis.annotations.Mapper;
import org.jboss.jandex.Main;

import java.util.List;

@Mapper
public interface MainImgRepository {
    boolean save(MainImg mainImg);

}
