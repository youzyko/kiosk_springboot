package com.example.kiosk.backgroundImg.repository;

import com.example.kiosk.backgroundImg.dto.ImageDataDto;
import com.example.kiosk.backgroundImg.entity.ImageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Mapper
public interface ImageDataRepository  {
//uploadImgRepo
    List<ImageDataDto> uploadImgRepo(ImageData imageData);



}
