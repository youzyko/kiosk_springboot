package com.example.kiosk.mainImage.service;

import com.example.kiosk.mainImage.dto.ImgAll;
import com.example.kiosk.mainImage.entity.MainImg;
import com.example.kiosk.mainImage.repository.MainImgRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jboss.jandex.Main;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MainImgService {
    private  final MainImgRepository mainImgRepository;

    public boolean upload(MainImg mainImg) { //이미지 등록
        return mainImgRepository.save(mainImg);
    }
    public List<MainImg> getProfilePath(){
        List<MainImg> id = mainImgRepository.findBackImg();
        log.info("find backImg path - {}", id);
        //find profile path - [\2023\04\03\95c60820-4a1f-4111-96a9-7798ac863583_images (1).jpg, \2023\04\06\a3e27c4b-050f-4509-8266-3adf76c8fd4d_images (1).jpg]
        return id;

       /* List<MainImg> mainImgs = mainImgRepository.findALll();
        log.info("size - {}",mainImgs.size() );

        ImgAll imgAll = new ImgAll(mainImgs);

        return imgAll;*/
    } //getProfile_end

/*    public ImgAll findAllServ() {
        return new ImgAll(mainImgRepository.findALll());
    }*/
}//class_end



