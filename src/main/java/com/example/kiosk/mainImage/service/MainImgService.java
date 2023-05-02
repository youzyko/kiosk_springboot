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
    public String getProfilePath(String id){
        String profile = mainImgRepository.findBackImg(id);
        log.info("find profile path - {}", profile);
        return profile;

       /* List<MainImg> mainImgs = mainImgRepository.findALll();
        log.info("size - {}",mainImgs.size() );

        ImgAll imgAll = new ImgAll(mainImgs);

        return imgAll;*/
    } //getProfile_end

    public List<String> findAllId() {
        return mainImgRepository.findAllId();
    }
    public List<MainImg>allInform(){
        return mainImgRepository.allInform();
    }

/*    public ImgAll findAllServ() {
        return new ImgAll(mainImgRepository.findALll());
    }*/

    public boolean deleteServ(String id){
        log.info("ITEM_DELETE_SERVICE");
        boolean f= mainImgRepository.delete(id);
        if (!f){ //f=flase
            log.warn("DELETE_FAIL==>{}",id);
            throw  new RuntimeException("MAINIMG_DELETE_FAILED");

        }
        return  f;
    } //delete_end


}//class_end



