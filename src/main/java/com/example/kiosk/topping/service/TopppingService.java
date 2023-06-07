package com.example.kiosk.topping.service;



import com.example.kiosk.item.entity.Item;

import com.example.kiosk.topping.entity.Toppping;
import com.example.kiosk.topping.repository.TopppingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TopppingService {
    private  final TopppingRepository topppingRepository;

    public List<Toppping> toppingAll(){ // 모든토핑
        log.info("GET_TOPPING_SERVICE");
        return  topppingRepository.toppingAll();
    }

    public boolean upload(Toppping toppping) { //이미지 등록
        log.info("ITEM_ADD_SERVICE");
        return topppingRepository.save(toppping);
    }


    public String getProfilePath(String ownImgId){
        String toppingImg=topppingRepository.findImg(ownImgId);
        log.info("find profile path - {}", toppingImg);
        return  toppingImg;
    }

    public List<String> findAllId() { //ownImgId만 가져오기
        log.info("TOPPING_ALLID_SERVICE");
        return topppingRepository.findAllId();
    }

    //삭제
    public boolean delete(String ownImgId){
        log.info("TOPPING_DELETE_SERVICE");
        return topppingRepository.delete(ownImgId);
    }


}//class_end
